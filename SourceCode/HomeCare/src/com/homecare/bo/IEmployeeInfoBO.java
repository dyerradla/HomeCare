package com.homecare.bo;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.homecare.domain.EmployeeInfo;

@Transactional
public interface IEmployeeInfoBO {
	
	public EmployeeInfo getEmployeeInfo(EmployeeInfo employeeInfo);

	public EmployeeInfo getEmployeeInfoByEmployeeId(Long employeeId);
	
	public void generateEmail();
	
	public EmployeeInfo sendEmail(Long employeeId);

	public List<EmployeeInfo> getAllEmployees(EmployeeInfo employeeInfo);

	public void updateEmployeeInfo(EmployeeInfo employeeInfo);
	
	public Map<String,EmployeeInfo> getAllReminders();
	
	public Map<String,EmployeeInfo> getRemindersByEmployee(Long employeeId);
	
	public List<EmployeeInfo> deleteEmployeeInfo(Long employeeId);
}
