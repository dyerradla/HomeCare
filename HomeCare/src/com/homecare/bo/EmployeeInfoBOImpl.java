package com.homecare.bo;

import org.springframework.beans.factory.annotation.Autowired;

import com.homecare.dao.IEmployeeDAO;
import com.homecare.domain.EmployeeInfo;

public class EmployeeInfoBOImpl implements IEmployeeInfoBO {
	@Autowired
	private IEmployeeDAO employeeDAO;

	public EmployeeInfo getEmployeeInfo(Long employeeId) {
		return employeeDAO.getEmployeeInfo(employeeId);
	}

	public void updateEmployeeInfo(EmployeeInfo employeeInfo) {
		employeeDAO.updateEmployeeInfo(employeeInfo);

	}

}
