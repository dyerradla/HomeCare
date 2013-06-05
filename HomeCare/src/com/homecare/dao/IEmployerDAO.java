package com.homecare.dao;

import java.util.List;

import com.homecare.domain.EmployerEmailInfo;
import com.homecare.domain.EmployerSendEmail;

public interface IEmployerDAO {

	public List<EmployerEmailInfo> getAllEmployerEmails(Long employerId);
	
	public EmployerSendEmail getEmployerSendEmail(Long employerId);
	
}
