package com.homecare.bo;

import org.springframework.transaction.annotation.Transactional;

import com.homecare.domain.EmployeeInfo;

@Transactional
public interface IEmployeeInfoBO {
	
	public EmployeeInfo getEmployeeInfo(Long employeeId);

	public void updateEmployeeInfo(EmployeeInfo employeeInfo);
}
