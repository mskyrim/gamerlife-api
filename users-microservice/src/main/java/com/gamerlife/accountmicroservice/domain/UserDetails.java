package com.gamerlife.accountmicroservice.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String country;
	private String city;
	private String town;
	private String adress;
	private String zipcode;
	private String psncode;
	private String miiverse;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPsncode() {
		return psncode;
	}
	public void setPsncode(String psncode) {
		this.psncode = psncode;
	}
	public String getMiiverse() {
		return miiverse;
	}
	public void setMiiverse(String miiverse) {
		this.miiverse = miiverse;
	}
	
	
}
