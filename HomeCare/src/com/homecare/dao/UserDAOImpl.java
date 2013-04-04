package com.homecare.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.homecare.domain.User;

public class UserDAOImpl extends BaseDAO implements IUserDAO {

	public boolean validateUser(String userName, String password) {
		logger.debug("Entering getAllEmployees of EmployeeDAOImpl");
		boolean validUser = false;
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.add(Restrictions.eq("password", password));
		List<User> userList = criteria.list();
		if(null != userList && !userList.isEmpty()){
			validUser = true;
		}
		return validUser;
	}

}
