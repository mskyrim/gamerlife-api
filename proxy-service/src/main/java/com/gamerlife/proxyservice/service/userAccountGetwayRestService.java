package com.gamerlife.proxyservice.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class userAccountGetwayRestService {

	private RestTemplate restTemplate;

	//@Autowired
	public userAccountGetwayRestService(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	public userAccountGetwayRestService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/users")
	public Collection<UserAccount> getAllUsers(){
		ParameterizedTypeReference<Resources<UserAccount>> responseType = new ParameterizedTypeReference<Resources<UserAccount>>() {
		};
		return restTemplate.exchange("http://useraccount-service/allAccounts", HttpMethod.GET, null, responseType).getBody().getContent();
	}
	
	class UserAccount {
		private String pseudo;
		private String email;
		public String getPseudo() {
			return pseudo;
		}
		public void setPseudo(String pseudo) {
			this.pseudo = pseudo;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
	}
}
