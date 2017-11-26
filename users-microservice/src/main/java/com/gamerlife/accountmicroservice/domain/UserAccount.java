package com.gamerlife.accountmicroservice.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Email;

@Entity
public class UserAccount implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String pseudo;
	@Email
	private String email;
	private String password;
	
	public UserAccount(String pseudo, String email, String password) {
		super();
		this.pseudo = pseudo;
		this.email = email;
		this.password = password;
	}
	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Pseudo : " + pseudo + " email : " + email;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
