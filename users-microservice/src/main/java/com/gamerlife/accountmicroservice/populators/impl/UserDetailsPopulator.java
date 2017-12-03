package com.gamerlife.accountmicroservice.populators.impl;

import org.springframework.stereotype.Component;

import com.gamerlife.accountmicroservice.domain.UserDetails;
import com.gamerlife.accountmicroservice.dto.UserDetailsData;
import com.gamerlife.accountmicroservice.populators.Populator;

@Component("userDetailsPopulator")
public class UserDetailsPopulator implements Populator<UserDetailsData, UserDetails> {

	@Override
	public void populate(UserDetailsData source, UserDetails target) {
		target.setAdress(source.getAdress());
		target.setCity(source.getCity());
		target.setCountry(source.getCountry());
		target.setMiiverse(source.getMiiverse());
		target.setPsncode(source.getPsncode());
		target.setTown(source.getTown());
		target.setZipcode(source.getZipcode());
	}

}
