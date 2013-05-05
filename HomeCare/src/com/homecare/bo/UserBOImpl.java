package com.homecare.bo;

import org.springframework.beans.factory.annotation.Autowired;

import com.homecare.dao.IUserDAO;
import com.homecare.domain.User;

public class UserBOImpl implements IUserBO {

	@Autowired
	private IUserDAO userDAO;
	public User validateUser(String userName, String password) {
		return userDAO.validateUser(userName, password);
	}

}
