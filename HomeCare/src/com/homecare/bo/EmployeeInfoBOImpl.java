package com.homecare.bo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.homecare.dao.IEmployeeDAO;
import com.homecare.domain.EmployeeInfo;
import com.homecare.utility.EmailUtility;

public class EmployeeInfoBOImpl implements IEmployeeInfoBO {
	
	private Log logger = LogFactory.getLog(EmployeeInfoBOImpl.class);
	@Autowired
	private IEmployeeDAO employeeDAO;

	public EmployeeInfo getEmployeeInfoByEmployeeId(Long employeeId) {
		return employeeDAO.getEmployeeInfoByEmployeeId(employeeId);
	}
	
	public EmployeeInfo getEmployeeInfo(EmployeeInfo employeeInfo) {
		return employeeDAO.getEmployeeInfo(employeeInfo);
	}
	

	public void updateEmployeeInfo(EmployeeInfo employeeInfo) {
		employeeDAO.updateEmployeeInfo(employeeInfo);

	}

	public List<EmployeeInfo> getAllEmployees(EmployeeInfo employeeInfo){
		return employeeDAO.getAllEmployees(employeeInfo);
	}

	public EmployeeInfo sendEmail(Long employeeId) {
		EmployeeInfo employeeInfo = employeeDAO.getEmployeeInfoByEmployeeId(employeeId);
		List<String> employeeReminderList = getRemindersByEmployee(employeeInfo);
		// Send an email
		String concatenatedReminderString ="";
		for(String remiderString : employeeReminderList){
			concatenatedReminderString += remiderString + "\n\n";
		}
		EmailUtility emailUtility = new EmailUtility();
		emailUtility.sendEmail("Reminders", employeeInfo.getEmailAddress(), concatenatedReminderString);
		return employeeInfo;
	}
	
	public List<EmployeeInfo> deleteEmployeeInfo(Long employeeId){
		employeeDAO.deleteEmployee(employeeId);
		return getAllEmployees(new EmployeeInfo());
	}
	
	public Map<String,EmployeeInfo> getAllReminders() {
		List<EmployeeInfo> employeeList = employeeDAO.getAllEmployees(new EmployeeInfo());
		return getEmployeeReminderMap(employeeList);
	}
	
	public Map<String,EmployeeInfo> getRemindersByEmployee(Long employeeId){
		EmployeeInfo employeeInfo = employeeDAO.getEmployeeInfoByEmployeeId(employeeId);
		List<EmployeeInfo> employeeList = new ArrayList<EmployeeInfo>();
		employeeList.add(employeeInfo);
		return getEmployeeReminderMap(employeeList);
	}
	
	private Map<String,EmployeeInfo> getEmployeeReminderMap(List<EmployeeInfo> employeeList){
		Map<String,EmployeeInfo> employeeRemindersMap = new HashMap<String, EmployeeInfo>();
		if(null != employeeList && !employeeList.isEmpty()){
			for(EmployeeInfo employeeInfo : employeeList){
				List<String> employeeReminderList = getRemindersByEmployee(employeeInfo);

				// If any of the reminders there then Put it in the Map with Last Name and First Name
				if(!employeeReminderList.isEmpty()){
					employeeInfo.setEmployeeReminderMessage(employeeReminderList);
					employeeRemindersMap.put(employeeInfo.getLastName()+" "+employeeInfo.getMiddleName() + " "+employeeInfo.getFirstName(),
							employeeInfo);
				}
				
				
			}
		}
		return employeeRemindersMap;
	}
	
	
	/**
	 * Get the Reminders By EmployeeId
	 * @param employeeInfo
	 * @return
	 */
	public List<String> getRemindersByEmployee(EmployeeInfo employeeInfo){
		Properties properties = new Properties();
		try {
		    properties.load(this.getClass().getResourceAsStream("/application.properties"));
		} catch (IOException e) {
			logger.error("Properties File not found");
		}
		
		Calendar currentcal = Calendar.getInstance();
		currentcal.add(Calendar.MONTH, 1);
		
		Calendar annualEvaluation = Calendar.getInstance();
		annualEvaluation.add(Calendar.YEAR, -1);
		
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
		
		if(null == employeeInfo.getInitialCompetencyEvaluation() || !employeeInfo.getInitialCompetencyEvaluation().after(currentcal.getTime())){
			employeeReminderList.add(properties.getProperty("INITIAL_COMPETENCY_REMINDER"));
		}
		
		if(null == employeeInfo.getOngoinCompetencyEvaluation() || !employeeInfo.getOngoinCompetencyEvaluation().after(currentcal.getTime())){
			employeeReminderList.add(properties.getProperty("ONGOING_COMPETENCY_REMINDER"));
		}
		if(null != employeeInfo.getAnnualEvaluation()){
			if(!employeeInfo.getAnnualEvaluation().after(annualEvaluation.getTime())){
				employeeReminderList.add(properties.getProperty("ANNUAL_EVALUTION_REMINDER"));
			}
		}else{
			if(!employeeInfo.getEmploymentDate().after(annualEvaluation.getTime())){
				employeeReminderList.add(properties.getProperty("ANNUAL_EVALUTION_REMINDER"));
			}
		}
		
		if(null == employeeInfo.getCprCard() || !employeeInfo.getCprCard().after(currentcal.getTime())){
			employeeReminderList.add(properties.getProperty("CPR_REMINDER"));
		}
		if(null == employeeInfo.getProfLicense() || !employeeInfo.getProfLicense().after(currentcal.getTime())){
			employeeReminderList.add(properties.getProperty("PROF_LICENSE_REMINDER"));
		}
		if(null == employeeInfo.getDriversLicense() || !employeeInfo.getDriversLicense().after(currentcal.getTime())){
			employeeReminderList.add(properties.getProperty("DRIVERS_LICENSE_REMINDER"));
		}
		if(null == employeeInfo.getProofValidCarInsurance() || !employeeInfo.getProofValidCarInsurance().after(currentcal.getTime())){
			employeeReminderList.add(properties.getProperty("PROOF_OF_CAR_INSURANCE_REMINDER"));
		}
		
		if(null == employeeInfo.getTbTest() || !employeeInfo.getTbTest().after(currentcal.getTime())){
			employeeReminderList.add(properties.getProperty("TBTEST_REMINDER"));
		}
		
		return employeeReminderList;
	}
}
