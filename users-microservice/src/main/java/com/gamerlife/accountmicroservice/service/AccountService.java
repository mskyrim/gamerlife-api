package com.gamerlife.accountmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gamerlife.accountmicroservice.domain.AccountRepository;
import com.gamerlife.accountmicroservice.domain.UserAccount;

@RestController
@RequestMapping(value="/userAccount")
public class AccountService {

	private final AccountRepository accountRepository;

	@Autowired
	public AccountService(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}
	
	@RequestMapping(value="/newAccount", method=RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody UserAccount userAccount){		
		return new ResponseEntity<>(accountRepository.save(userAccount), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/allAccounts", method=RequestMethod.GET)
	public List<UserAccount> allAccounts(){		
		return accountRepository.findAll();
	}
	
	@RequestMapping(value="/getAccountByPseudo/{pseudo}", method=RequestMethod.GET)
	public UserAccount getAccountByPseudo(@PathVariable String pseudo){		
		return accountRepository.findAccountByPseudo(pseudo);
	}
	
	
}
