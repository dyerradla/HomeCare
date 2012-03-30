package com.homecare.dao;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;

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
		 StringBuilder query = new StringBuilder("from EmployeeInfo ");
		 Calendar currentcal = Calendar.getInstance();
		 currentcal.add(Calendar.MONTH, 1);
		 
		 //Applying the restrictions on Application
		 query.append(" where application != 'Y'");
		 
		//Applying the restrictions on Resume
		 query.append(" OR resume != 'Y'");
		 
		//Applying the restrictions on Reference Checks
		 query.append(" OR referenceChecks != 'Y'");
		 
		//Applying the restrictions on SignedJobDescription
		 query.append(" OR signedJobDescription != 'Y'");
		 
		//Applying the restrictions on OrientationChecklist
		 query.append(" OR orientationChecklist != 'Y'");
		 
		//Applying the restrictions on StatementOfConfidentiality
		 query.append(" OR statementOfConfidentiality != 'Y'");
		 
		//Applying the restrictions on Policy
		 query.append(" OR policy != 'Y'"); 

		//Applying the restrictions on HippaTraining
		 query.append(" OR hippaTraining != 'Y'");  
		
		//Applying the restrictions on OshaTraining
		 query.append(" OR oshaTraining != 'Y'");  
		
		//Applying the restrictions on VerificationProfLicense
		 query.append(" OR verificationProfLicense != 'Y'");
		 
		//Applying the restrictions on SocialSecurityCard
		 query.append(" OR socialSecurityCard != 'Y'");
		 
		//Applying the restrictions on NonCompete
		 query.append(" OR nonCompete != 'Y'"); 
		
		//Applying the restrictions on AuthorizationCriminalCheck
		 query.append(" OR authorizationCriminalCheck != 'Y'");
		 
		//Applying the restrictions on CriminalCheck
		 query.append(" OR criminalCheck != 'Y'");
		 
		//Applying the restrictions on FingerprintsResults
		 query.append(" OR fingerprintsResults != 'Y'");
		 
		//Applying the restrictions on FederalW4
		 query.append(" OR federalW4 != 'Y'");
		 
		//Applying the restrictions on MichiganW4
		 query.append(" OR michiganW4 != 'Y'"); 
		
		//Applying the restrictions on I9
		 query.append(" OR i9 != 'Y'");
		 
		//Applying the restrictions on HvbTest
		 query.append(" OR hvbTest != 'Y'");
		 
		 // Applying the Restrictions on CPR card
		 query.append(" OR initialCompetencyEvaluation <= '"+currentcal.getTime()+"'");
		
		 // Applying the Restrictions on CPR card
		 query.append(" OR ongoinCompetencyEvaluation <= '"+currentcal.getTime()+"'");
		
		 // Applying the Restrictions on CPR card
		 query.append(" OR annualEvaluation <= '"+currentcal.getTime()+"'");
		
		 // Applying the Restrictions on CPR card
		 query.append(" OR cprCard <= '"+currentcal.getTime()+"'");
		
		 // Applying the Restrictions on CPR card
		 query.append(" OR profLicense <= '"+currentcal.getTime()+"'");
		
		 // Applying the Restrictions on CPR card
		 query.append(" OR driversLicense <= '"+currentcal.getTime()+"'");
		
		 // Applying the Restrictions on CPR card
		 query.append(" OR proofValidCarInsurance <= '"+currentcal.getTime()+"'");
		
		 // Applying the Restrictions on CPR card
		 query.append(" OR tbTest <= '"+currentcal.getTime()+"'");
		 
		 Query selectQuery = getSession().createQuery(query.toString());
		
		List<EmployeeInfo> employeeList = selectQuery.list();
		logger.debug("Exiting getAllReminders of EmployeeDAOImpl"+employeeList.size());
		return employeeList;
	}
}
