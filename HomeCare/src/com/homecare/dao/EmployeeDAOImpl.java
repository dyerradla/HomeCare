package com.homecare.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.homecare.domain.EmployeeInfo;

public class EmployeeDAOImpl extends BaseDAO implements IEmployeeDAO {
	private Log logger = LogFactory.getLog(EmployeeDAOImpl.class);
	
	/**
	 * Get the Employee information for the given employeeId
	 */
	public EmployeeInfo getEmployeeInfo(Long employeeId) {
		logger.debug("Entering getEmployeeInfo of EmployeeDAOImpl with employeeId:"+employeeId);
		EmployeeInfo employeeInfo = (EmployeeInfo)loadObjectByPrimaryKey(EmployeeInfo.class, employeeId);
		logger.debug("Exiting getEmployeeInfo of EmployeeDAOImpl with employeeId:"+employeeId);
		return employeeInfo;
	}

	/**
	 * Get the List of all the employees
	 */
	public List<EmployeeInfo> getAllEmployees() {
		logger.debug("Entering getAllEmployees of EmployeeDAOImpl");
		Criteria criteria = getSession().createCriteria(EmployeeInfo.class);
		List<EmployeeInfo> employeeList = criteria.list();
		logger.debug("Exiting getAllEmployees of EmployeeDAOImpl");
		return employeeList;
	}


	/**
	 * Update or Add the given Employee
	 */
	public void updateEmployeeInfo(EmployeeInfo employeeInfo) {
		saveOrUpdateObject(employeeInfo);
	}
	
	/**
	 * Get all the Reminders
	 * @return
	 */
	public List<EmployeeInfo> getAllReminders(){
		
		logger.debug("Entering getAllReminders of EmployeeDAOImpl");
		Criteria criteria = getSession().createCriteria(EmployeeInfo.class);
		criteria.add(Restrictions.ne("application", "Y"));
		List<EmployeeInfo> employeeList = criteria.list();
		logger.debug("Exiting getAllReminders of EmployeeDAOImpl");
		return employeeList;
	}
}
