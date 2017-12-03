package com.gamerlife.accountmicroservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping(value="/contactUs")
public class ContactUsService {

	@Value("${author}")
	private String author;

	@RequestMapping(value="/aboutme", method=RequestMethod.GET)
	public String aboutme(){	
		System.out.println("-------------------------");
		System.out.println("It's me who reponds ");
		System.out.println("-------------------------");
		return this.author;
	}
	
	
}
