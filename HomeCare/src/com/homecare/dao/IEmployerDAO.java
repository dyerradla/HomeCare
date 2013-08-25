package com.homecare.dao;

import java.util.List;

import com.homecare.domain.EmployerEmailInfo;
import com.homecare.domain.EmployerInfo;

public interface IEmployerDAO {

	public List<EmployerEmailInfo> getAllEmployerEmails(Long employerId);
	
	public EmployerInfo getEmployerInfo(Long employerId);
	
	public void saveEmployer(EmployerInfo employerInfo);
	
}
