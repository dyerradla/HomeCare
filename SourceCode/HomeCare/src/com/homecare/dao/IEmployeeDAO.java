package com.homecare.dao;

import java.util.List;

import com.homecare.domain.EmployeeInfo;

public interface IEmployeeDAO {

	public EmployeeInfo getEmployeeInfo(EmployeeInfo employeeInfo);

	public EmployeeInfo getEmployeeInfoByEmployeeId(Long employeeId);
	
	public List<EmployeeInfo> getAllEmployees(EmployeeInfo employeeInfo);
	
	public void updateEmployeeInfo(EmployeeInfo employeeInfo);
	
	public void deleteEmployee(Long employeeId);
	
}
