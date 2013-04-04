package com.homecare.bo;

import org.springframework.beans.factory.annotation.Autowired;

import com.homecare.dao.IUserDAO;

public class UserBOImpl implements IUserBO {

	@Autowired
	private IUserDAO userDAO;
	public boolean validateUser(String userName, String password) {
		return userDAO.validateUser(userName, password);
	}

}
