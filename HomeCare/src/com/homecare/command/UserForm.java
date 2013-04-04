package com.homecare.command;

import com.homecare.domain.User;

public class UserForm {
	
	private User user = new User();
	private String validUser;
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

}
