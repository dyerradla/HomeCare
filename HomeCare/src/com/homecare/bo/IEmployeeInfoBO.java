package com.homecare.bo;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.homecare.domain.EmployeeInfo;

@Transactional
public interface IEmployeeInfoBO {
	
	public EmployeeInfo getEmployeeInfo(Long employeeId);
	
	public List<EmployeeInfo> getAllEmployees();

	public void updateEmployeeInfo(EmployeeInfo employeeInfo);
}
