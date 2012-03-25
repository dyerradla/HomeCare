package com.homecare.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;

import com.homecare.domain.EmployeeInfo;

public class EmployeeDAOImpl extends BaseDAO implements IEmployeeDAO {
	private Log logger = LogFactory.getLog(EmployeeDAOImpl.class);
	public EmployeeInfo getEmployeeInfo(Long employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EmployeeInfo> getAllEmployees() {
		logger.debug("Entering getAllEmplyees of EmployeeDAOImpl");
		Criteria criteria = getSession().createCriteria(EmployeeInfo.class);
		List<EmployeeInfo> employeeList = criteria.list();
		logger.debug("Exiting getAllEmplyees of EmployeeDAOImpl");
		return employeeList;
	}


	public void updateEmployeeInfo(EmployeeInfo employeeInfo) {
		// TODO Auto-generated method stub

	}
}
