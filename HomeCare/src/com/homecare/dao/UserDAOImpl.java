package com.homecare.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.homecare.domain.User;

public class UserDAOImpl extends BaseDAO implements IUserDAO {

	public User validateUser(String userName, String password) {
		logger.debug("Entering getAllEmployees of EmployeeDAOImpl");
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.add(Restrictions.eq("password", password));
		List<User> userList = criteria.list();
		User selectedUser = new User();
		if(null != userList && !userList.isEmpty()){
			selectedUser = userList.get(0);
			selectedUser.setValidUser(true);  
		}
		return selectedUser;
	}
	
	public void saveUser(User user){
		saveOrUpdateObject(user);
	}
}
