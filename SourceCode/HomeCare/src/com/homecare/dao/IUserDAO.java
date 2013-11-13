package com.homecare.dao;

import com.homecare.domain.User;

public interface IUserDAO {

	public User validateUser(String userName, String password);
	
	public User findUserByEmail(String email);
	
	public void saveUser(User user);
}
