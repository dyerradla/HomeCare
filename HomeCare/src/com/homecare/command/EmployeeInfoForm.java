package com.homecare.command;

import com.homecare.domain.EmployeeInfo;

public class EmployeeInfoForm {
	
	private EmployeeInfo employeeInfo = new EmployeeInfo();

	public EmployeeInfo getEmployeeInfo() {
		return employeeInfo;
	}

	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}
}
