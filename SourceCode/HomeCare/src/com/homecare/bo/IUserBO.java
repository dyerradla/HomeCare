package com.homecare.bo;

import com.homecare.domain.User;

public interface IUserBO {
	
	public User validateUser(String userName, String password);

}
