package com.homecare.dao;

import com.homecare.domain.EmployeeInfo;

public interface IEmployeeDAO {

	public EmployeeInfo getEmployeeInfo(Long employeeId);

	public void updateEmployeeInfo(EmployeeInfo employeeInfo);

}
