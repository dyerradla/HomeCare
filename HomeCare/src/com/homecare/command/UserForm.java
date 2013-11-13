package com.homecare.command;

import com.homecare.domain.EmployerInfo;
import com.homecare.domain.User;

public class UserForm {
	
	private User user = new User();
	private EmployerInfo employerInfo = new EmployerInfo();
	private String validUser;
	private String email;
	private String status;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getValidUser() {
		return validUser;
	}

	public void setValidUser(String validUser) {
		this.validUser = validUser;
	}

	public EmployerInfo getEmployerInfo() {
		return employerInfo;
	}

	public void setEmployerInfo(EmployerInfo employerInfo) {
		this.employerInfo = employerInfo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
