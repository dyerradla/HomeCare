package com.homecare.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.homecare.domain.CodeValue;
import com.homecare.domain.EmployeeInfo;

public class EmployeeDAOImpl extends BaseDAO implements IEmployeeDAO {
	private Log logger = LogFactory.getLog(EmployeeDAOImpl.class);
	
	/**
	 * Get the Employee information for the given employeeId
	 */
	public EmployeeInfo getEmployeeInfoByEmployeeId(Long employeeId) {
		logger.debug("Entering getEmployeeInfoByEmployeeId of EmployeeDAOImpl with employeeId:"+employeeId);
		EmployeeInfo employeeInfo = (EmployeeInfo)loadObjectByPrimaryKey(EmployeeInfo.class, employeeId);
		logger.debug("Exiting getEmployeeInfo of EmployeeDAOImpl with employeeId:"+employeeId);
		return employeeInfo;
	}

	
	/**
	 * Get the List of all the employees by given Search Criteria
	 */
	public EmployeeInfo getEmployeeInfo(EmployeeInfo employeeInfo) {
		logger.debug("Entering getEmployeeInfo of EmployeeDAOImpl");
		Criteria criteria = getSession().createCriteria(EmployeeInfo.class);
		if(StringUtils.isNotBlank(employeeInfo.getLastName())){
			criteria.add(Restrictions.like("lastName", employeeInfo.getLastName()));
		}
		if(StringUtils.isNotBlank(employeeInfo.getFirstName())){
			criteria.add(Restrictions.like("firstName", employeeInfo.getFirstName()));
		}
		if(StringUtils.isNotBlank(employeeInfo.getMiddleName())){
			criteria.add(Restrictions.like("middleName", employeeInfo.getMiddleName()));
		}
		if(null != employeeInfo.getEmployeeId()){
			criteria.add(Restrictions.eq("employeeId", employeeInfo.getEmployeeId()));
		}
		if(null != employeeInfo.getEmployerId()){
			criteria.add(Restrictions.eq("employerId", employeeInfo.getEmployerId()));
		}
		criteria.addOrder(Order.asc("firstName"));
		List<EmployeeInfo> employeeList = criteria.list();
		logger.debug("Exiting getAllEmployees of EmployeeDAOImpl");
		EmployeeInfo selectedEmployeeInfo = null;
		if(null != employeeList && !employeeList.isEmpty()){
			selectedEmployeeInfo = employeeList.get(0);
		}
		return selectedEmployeeInfo;
	}
	
	/**
	 * Get the List of all the employees
	 */
	public List<EmployeeInfo> getAllEmployees(EmployeeInfo employeeInfo) {
		logger.debug("Entering getAllEmployees of EmployeeDAOImpl");
		Criteria criteria = getSession().createCriteria(EmployeeInfo.class);
		if(null != employeeInfo.getFirstName() && !"".equalsIgnoreCase(employeeInfo.getFirstName())){
			criteria.add(Restrictions.like("firstName", employeeInfo.getFirstName()));
		}
		if(null != employeeInfo.getLastName() && !"".equalsIgnoreCase(employeeInfo.getLastName())){
			criteria.add(Restrictions.like("lastName", employeeInfo.getLastName()));
		}
		if(null != employeeInfo.getStatus() && !"".equalsIgnoreCase(employeeInfo.getStatus())){
			criteria.add(Restrictions.like("status", employeeInfo.getStatus()));
		}
		if(null != employeeInfo.getEmployerId()){
			criteria.add(Restrictions.like("employerId", employeeInfo.getEmployerId()));
		}
		
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
	 * Delete the Selected Employee
	 */
	public void deleteEmployee(Long employeeId) {
		EmployeeInfo employeeInfo  = getEmployeeInfoByEmployeeId(employeeId);
		deleteObject(employeeInfo);
	}


	public List<CodeValue> getMessageMapByType(String type) {
		logger.debug("Entering getMessageMapByType of EmployeeDAOImpl with type:"+type);
		Criteria criteria = getSession().createCriteria(CodeValue.class);
		criteria.add(Restrictions.like("type", type));
		logger.debug("Exiting getMessageMapByType of EmployeeDAOImpl with type:"+type);
		return criteria.list();
	}
}
