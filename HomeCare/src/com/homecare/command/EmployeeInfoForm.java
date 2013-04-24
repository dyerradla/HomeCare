package com.homecare.command;

import com.homecare.domain.EmployeeInfo;

public class EmployeeInfoForm {
	
	private EmployeeInfo employeeInfo = new EmployeeInfo();
	
	public String selectedEmployeeLastName;
	public String selectedEmployeeFirstName;
	public String selectedStatus;
	public EmployeeInfo getEmployeeInfo() {
		return employeeInfo;
	}

	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	public String getSelectedEmployeeLastName() {
		return selectedEmployeeLastName;
	}

	public void setSelectedEmployeeLastName(String selectedEmployeeLastName) {
		this.selectedEmployeeLastName = selectedEmployeeLastName;
	}

	public String getSelectedEmployeeFirstName() {
		return selectedEmployeeFirstName;
	}

	public void setSelectedEmployeeFirstName(String selectedEmployeeFirstName) {
		this.selectedEmployeeFirstName = selectedEmployeeFirstName;
	}

	public String getSelectedStatus() {
		return selectedStatus;
	}

	public void setSelectedStatus(String selectedStatus) {
		this.selectedStatus = selectedStatus;
	}
}
