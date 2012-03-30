package com.homecare.command;

import com.homecare.domain.EmployeeInfo;

public class EmployeeInfoForm {
	
	private EmployeeInfo employeeInfo = new EmployeeInfo();
	private Long selectedEmployeeId;
	public EmployeeInfo getEmployeeInfo() {
		return employeeInfo;
	}

	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	public Long getSelectedEmployeeId() {
		return selectedEmployeeId;
	}

	public void setSelectedEmployeeId(Long selectedEmployeeId) {
		this.selectedEmployeeId = selectedEmployeeId;
	}

}
