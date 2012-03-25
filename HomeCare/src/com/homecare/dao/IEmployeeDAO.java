package com.homecare.dao;

import java.util.List;

import com.homecare.domain.EmployeeInfo;

public interface IEmployeeDAO {

	public EmployeeInfo getEmployeeInfo(Long employeeId);

	public List<EmployeeInfo> getAllEmployees();
	
	public void updateEmployeeInfo(EmployeeInfo employeeInfo);

}
