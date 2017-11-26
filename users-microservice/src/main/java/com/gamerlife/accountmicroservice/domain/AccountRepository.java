package com.gamerlife.accountmicroservice.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AccountRepository extends JpaRepository<UserAccount, Long> {
	
	@Query("select account from UserAccount account where account.pseudo = :pseudo")
	public UserAccount findAccountByPseudo(String pseudo);

}
