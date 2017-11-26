package com.gamerlife.accountmicroservice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.gamerlife.accountmicroservice.domain.AccountRepository;
import com.gamerlife.accountmicroservice.domain.UserAccount;import com.gamerlife.accountmicroservice.service.AccountService;

@SpringBootApplication
public class UsersMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersMicroserviceApplication.class, args);
	}
	
	@Component
	class AccountLineRunner implements CommandLineRunner{
		
		private final AccountRepository accountRepository;
		
		
		@Autowired
		public AccountLineRunner(AccountRepository accountRepository) {
			super();
			this.accountRepository = accountRepository;
		}

		@Override
		public void run(String... arg0) throws Exception {
			// TODO Auto-generated method stub
			Stream<UserAccount> accounts = Arrays.asList(
					new UserAccount("Mido","dardani.mehdi@gmail.com","root"),
					new UserAccount("Mocha","salma.fal@gmail.com","root")
					)
					.stream();
			accounts.forEach(ac -> this.accountRepository.save(ac));
			this.accountRepository.findAll().stream().forEach(System.out::println);
		}
		
	}
}
