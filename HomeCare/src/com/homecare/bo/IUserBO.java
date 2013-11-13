package com.homecare.bo;

import com.homecare.domain.EmployerInfo;
import com.homecare.domain.User;

public interface IUserBO {
	
	public User validateUser(String userName, String password);
	
	public void saveUser(User user);
	
	public EmployerInfo loadEmployer(Long employerId);
	
	public String sendPasswordEmail(String email);

	public void saveEmployer(EmployerInfo employerInfo);
}
