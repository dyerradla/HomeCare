package com.homecare.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user", catalog = "homecare")
public class User {

	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String middleName;
	private String primaryEmail;
	private String alternateEmail1;
	private String alternateEmail2;
	private boolean validUser = false;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_NAME", unique = true, nullable = false)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "PASSWORD", nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "FIRST_NAME", nullable = false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "LAST_NAME", nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "MIDDLE_NAME")
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	

	@Column(name="PRIMARY_EMAIL",nullable = false)
	public String getPrimaryEmail() {
		return primaryEmail;
	}
	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}
	
	@Column(name="ALTER_EMAIL_1")
	public String getAlternateEmail1() {
		return alternateEmail1;
	}
	public void setAlternateEmail1(String alternateEmail1) {
		this.alternateEmail1 = alternateEmail1;
	}
	
	@Column(name="ALTER_EMAIL_2")
	public String getAlternateEmail2() {
		return alternateEmail2;
	}
	public void setAlternateEmail2(String alternateEmail2) {
		this.alternateEmail2 = alternateEmail2;
	}
	@Transient
	public boolean isValidUser() {
		return validUser;
	}
	public void setValidUser(boolean validUser) {
		this.validUser = validUser;
	}
}
