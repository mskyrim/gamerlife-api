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
import com.gamerlife.accountmicroservice.domain.UserDetails;
import com.gamerlife.accountmicroservice.dto.LoginData;
import com.gamerlife.accountmicroservice.dto.UserDetailsData;
import com.gamerlife.accountmicroservice.populators.Populator;

@RestController
@RequestMapping(value="/userAccount")
public class AccountService {

	private final AccountRepository accountRepository;	
	private Populator<UserDetailsData, UserDetails> userDetailsPopulator;

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
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public UserAccount userLogin(final LoginData loginData){
		UserAccount userAccount = null;
		userAccount = accountRepository.userLogin(loginData.getEmail(), loginData.getPassword());
		return userAccount;
	}
	
	@RequestMapping(value="/updateAccount", method=RequestMethod.POST)
	public ResponseEntity<?> updateUserDetail(@RequestBody UserDetailsData userDetailsData){
		UserAccount userAccount = accountRepository.findAccountByPseudo(userDetailsData.getPseudo());
		if(userAccount != null){
			UserDetails userDetails = (userAccount.getUserDetail() != null ? userAccount.getUserDetail() : new UserDetails());
			this.userDetailsPopulator.populate(userDetailsData, userDetails);
		}else{
			new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(accountRepository.save(userAccount), HttpStatus.CREATED);
	}

	public Populator<UserDetailsData, UserDetails> getUserDetailsPopulator() {
		return userDetailsPopulator;
	}

	@Autowired
	public void setUserDetailsPopulator(Populator<UserDetailsData, UserDetails> userDetailsPopulator) {
		this.userDetailsPopulator = userDetailsPopulator;
	}
	
}
