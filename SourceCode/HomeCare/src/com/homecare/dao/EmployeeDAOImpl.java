package com.homecare.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

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
	public Map<String,List<String>> getAllReminders(){
		Properties properties = new Properties();
		try {
		    properties.load(this.getClass().getResourceAsStream("/application.properties"));
		} catch (IOException e) {
			logger.error("Properties File not found");
		}
		
		Map<String,List<String>> employeeRemindersMap = new HashMap<String, List<String>>();
		logger.debug("Entering getAllReminders of EmployeeDAOImpl");
		 StringBuilder query = new StringBuilder("from EmployeeInfo ");
		
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
		 
		 Query selectQuery = getSession().createQuery(query.toString());
		
		List<EmployeeInfo> employeeList = selectQuery.list();
		
		if(null != employeeList && !employeeList.isEmpty()){
			for(EmployeeInfo employeeInfo : employeeList){
				List<String> employeeReminderList = new ArrayList<String>();
				if(null == employeeInfo.getApplication() || 'Y' != employeeInfo.getApplication()){
					employeeReminderList.add(properties.getProperty("APPLICATION_REMINDER"));
				}
				
				if(null == employeeInfo.getResume() || employeeInfo.getResume() != 'Y'){
					employeeReminderList.add(properties.getProperty("RESUME_REMINDER"));
				}
				
				if(null == employeeInfo.getReferenceChecks() || 'Y' != employeeInfo.getReferenceChecks()){
					employeeReminderList.add(properties.getProperty("REFERENCES_CHECK_REMINDER"));
				}
				
				if(null == employeeInfo.getSignedJobDescription() || employeeInfo.getSignedJobDescription() != 'Y'){
					employeeReminderList.add(properties.getProperty("SIGNED_JOB_REMINDER"));
				}
				
				if(null == employeeInfo.getOrientationChecklist() || employeeInfo.getOrientationChecklist() != 'Y'){
					employeeReminderList.add(properties.getProperty("ORIENTATION_CHECKLIST_REMINDER"));
				}
				
				if(null == employeeInfo.getStatementOfConfidentiality() || employeeInfo.getStatementOfConfidentiality() != 'Y'){
					employeeReminderList.add(properties.getProperty("STATEMENT_OF_CONFIDENTIALITY_REMINDER"));
				}
				
				if(null == employeeInfo.getPolicy() || employeeInfo.getPolicy() != 'Y'){
					employeeReminderList.add(properties.getProperty("POLICY_REMINDER"));
				}
				
				if(null == employeeInfo.getHippaTraining() || employeeInfo.getHippaTraining() != 'Y'){
					employeeReminderList.add(properties.getProperty("HIPPA_REMINDER"));
				}
				 
				if(null == employeeInfo.getOshaTraining() || employeeInfo.getOshaTraining() != 'Y'){
					employeeReminderList.add(properties.getProperty("OSHA_REMINDER"));
				}
				
				if(null == employeeInfo.getVerificationProfLicense() || employeeInfo.getVerificationProfLicense() != 'Y'){
					employeeReminderList.add(properties.getProperty("VERIFICATION_OF_PROF_LICENSE_REMINDER"));
				}
				
				if(null == employeeInfo.getSocialSecurityCard() || employeeInfo.getSocialSecurityCard() != 'Y'){
					employeeReminderList.add(properties.getProperty("SSN_REMINDER"));
				}
				
				if(null == employeeInfo.getNonCompete() || employeeInfo.getNonCompete() != 'Y'){
					employeeReminderList.add(properties.getProperty("NON_COMPETE_REMINDER"));
				}
				 
				if(null == employeeInfo.getAuthorizationCriminalCheck() || employeeInfo.getAuthorizationCriminalCheck() != 'Y'){
					employeeReminderList.add(properties.getProperty("AUTHORIZATION_CRIMINAL_CHECK_REMINDER"));
				}
				
				if(null == employeeInfo.getCriminalCheck() || employeeInfo.getCriminalCheck() != 'Y'){
					employeeReminderList.add(properties.getProperty("CRIMINAL_CHECK_REMINDER"));
				}
				
				if(null == employeeInfo.getFingerprintsResults() || employeeInfo.getFingerprintsResults() != 'Y'){
					employeeReminderList.add(properties.getProperty("FINGER_PRINT_RESULTS_REMINDER"));
				}
				
				if(null == employeeInfo.getFederalW4() || employeeInfo.getFederalW4() != 'Y'){
					employeeReminderList.add(properties.getProperty("FEDERAL_W4_REMINDER"));
				} 
				 
				if(null == employeeInfo.getMichiganW4() || employeeInfo.getMichiganW4() != 'Y'){
					employeeReminderList.add(properties.getProperty("MICHIGAN_W4_REMINDER"));
				}
				
				if(null == employeeInfo.getI9() || employeeInfo.getI9() != 'Y'){
					employeeReminderList.add(properties.getProperty("I9_REMINDER"));
				}
				
				if(null == employeeInfo.getHvbTest() || employeeInfo.getHvbTest() != 'Y'){
					employeeReminderList.add(properties.getProperty("TBTEST_REMINDER"));
				} 

				// If any of the reminders there then Put it in the Map with Last Name and First Name
				if(!employeeReminderList.isEmpty()){
					employeeRemindersMap.put(employeeInfo.getLastName()+" "+employeeInfo.getMiddleName() + " "+employeeInfo.getFirstName(),
							employeeReminderList);
				}
			}
		}
		
		logger.debug("Exiting getAllReminders of EmployeeDAOImpl"+employeeList.size());
		return employeeRemindersMap;
	}
}
