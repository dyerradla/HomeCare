package com.homecare.bo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import com.homecare.dao.IEmployeeDAO;
import com.homecare.domain.EmployeeInfo;
import com.homecare.utility.EmailUtility;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.pdf.PdfWriter;

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

	@Scheduled(cron="* * 1 * * ?")
	@Async
	public void generateEmail(){
		System.out.println("*****Generate Email");
		EmployeeInfo employeeInfoRequest = new EmployeeInfo();
		List<EmployeeInfo> employeeInfoList = employeeDAO.getAllEmployees(employeeInfoRequest);
		if(null != employeeInfoList){
			for(EmployeeInfo employeeInfo : employeeInfoList){
				sendEmail(employeeInfo.getEmployeeId());
			}
		}
	}
	
	@Scheduled(cron="* * 1 * * ?")
	@Async
	public void generatePDFAndEmailForAllEmployees(){
		System.out.println("************************************Print All the Reminders");
		List<EmployeeInfo> employeeList = employeeDAO.getAllEmployees(new EmployeeInfo());
	
		Document document = new Document(); 
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			PdfWriter.getInstance(document, out);        
			document.open();     
			if(null != employeeList){
				for(EmployeeInfo employeeInfo : employeeList){
					List<String> reminders = getRemindersByEmployee(employeeInfo);
					com.itextpdf.text.List list = new com.itextpdf.text.List();
					if(reminders != null && !reminders.isEmpty()){
						document.add(new Chunk(employeeInfo.getLastName() + " " + employeeInfo.getFirstName()));
						for(String reminder : reminders){
							// Add the list items to list        l
							list.add(new ListItem(reminder));      
						}
						document.add(list);
						document.newPage();
					}
				} 
			}
			document.close();
			EmailUtility emailUtility = new EmailUtility();
			emailUtility.sendEmailWithAttachment("Reminders of all the employees", "prasad14_gitam@yahoo.com", out.toByteArray());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//clean off           
			if(null != out) {            
				try { 
					out.close();
					out = null; 
				}               
				catch(Exception ex) { }       
			}
		}
	}
	
	private String getConcatenatedEmailBody(String emailBody,EmployeeInfo employeeInfo){
		List<String> employeeReminderList = getRemindersByEmployee(employeeInfo);
		// Send an email
		String concatenatedReminderString = "";
		for(String remiderString : employeeReminderList){
			concatenatedReminderString += "<div>"+remiderString + "</div>";
		}
		emailBody += "<div style=\"color:red;\">" + employeeInfo.getLastName() +"  " + employeeInfo.getFirstName() +"</div>" + concatenatedReminderString;
		
		return emailBody;
	}
	
	public EmployeeInfo sendEmail(Long employeeId) {
		EmployeeInfo employeeInfo = employeeDAO.getEmployeeInfoByEmployeeId(employeeId);
		List<String> employeeReminderList = getRemindersByEmployee(employeeInfo);
		// Send an email
		String concatenatedReminderString ="";
		for(String remiderString : employeeReminderList){
			concatenatedReminderString += remiderString + "\n\n";
		}
		if(!StringUtils.isEmpty(concatenatedReminderString)){
			EmailUtility emailUtility = new EmailUtility();
			emailUtility.sendEmail("Reminders", employeeInfo.getEmailAddress(), concatenatedReminderString);
		}
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
		annualEvaluation.add(Calendar.MONTH, 1);
		
		List<String> employeeReminderList = new ArrayList<String>();
		if(null == employeeInfo.getApplication() || employeeInfo.getApplication() == 'N'){
			employeeReminderList.add(properties.getProperty("APPLICATION_REMINDER"));
		}
		
		if(null == employeeInfo.getResume() || employeeInfo.getResume() =='N'){
			employeeReminderList.add(properties.getProperty("RESUME_REMINDER"));
		}
		
		if(null == employeeInfo.getReferenceChecks() || employeeInfo.getReferenceChecks() == 'N'){
			employeeReminderList.add(properties.getProperty("REFERENCES_CHECK_REMINDER"));
		}
		
		if(null == employeeInfo.getSignedJobDescription() || employeeInfo.getSignedJobDescription() =='N'){
			employeeReminderList.add(properties.getProperty("SIGNED_JOB_REMINDER"));
		}
		
		if(null == employeeInfo.getOrientationChecklist() || employeeInfo.getOrientationChecklist() =='N'){
			employeeReminderList.add(properties.getProperty("ORIENTATION_CHECKLIST_REMINDER"));
		}
		
		if(null == employeeInfo.getStatementOfConfidentiality() || employeeInfo.getStatementOfConfidentiality() =='N'){
			employeeReminderList.add(properties.getProperty("STATEMENT_OF_CONFIDENTIALITY_REMINDER"));
		}
		
		if(null == employeeInfo.getPolicy() || employeeInfo.getPolicy() =='N'){
			employeeReminderList.add(properties.getProperty("POLICY_REMINDER"));
		}
		
	
		
		if(null == employeeInfo.getSocialSecurityCard() || employeeInfo.getSocialSecurityCard() =='N'){
			employeeReminderList.add(properties.getProperty("SSN_REMINDER"));
		}
		
		if(null == employeeInfo.getNonCompete() || employeeInfo.getNonCompete() =='N'){
			employeeReminderList.add(properties.getProperty("NON_COMPETE_REMINDER"));
		}
		 
		if(null == employeeInfo.getAuthorizationCriminalCheck() || employeeInfo.getAuthorizationCriminalCheck() =='N'){
			employeeReminderList.add(properties.getProperty("AUTHORIZATION_CRIMINAL_CHECK_REMINDER"));
		}
		
		if(null == employeeInfo.getCriminalCheck() || employeeInfo.getCriminalCheck() =='N'){
			employeeReminderList.add(properties.getProperty("CRIMINAL_CHECK_REMINDER"));
		}
		
		if(null == employeeInfo.getFingerprintsResults() || employeeInfo.getFingerprintsResults() =='N'){
			employeeReminderList.add(properties.getProperty("FINGER_PRINT_RESULTS_REMINDER"));
		}
		
		if(null == employeeInfo.getFederalW4() || employeeInfo.getFederalW4() =='N'){
			employeeReminderList.add(properties.getProperty("FEDERAL_W4_REMINDER"));
		} 
		 
		if(null == employeeInfo.getMichiganW4() || employeeInfo.getMichiganW4() =='N'){
			employeeReminderList.add(properties.getProperty("MICHIGAN_W4_REMINDER"));
		}
		
		if(null == employeeInfo.getI9() || employeeInfo.getI9() =='N'){
			employeeReminderList.add(properties.getProperty("I9_REMINDER"));
		}
		
		Calendar employmentDate = Calendar.getInstance();
		employmentDate.setTime(employeeInfo.getEmploymentDate());
		employmentDate.add(Calendar.MONTH, 3);
		if(null == employeeInfo.getOngoinCompetencyEvaluation() || employeeInfo.getOngoinCompetencyEvaluation().after(employmentDate.getTime())){
			employeeReminderList.add(properties.getProperty("ONGOING_COMPETENCY_REMINDER"));
		}
		
		if(null == employeeInfo.getInitialCompetencyEvaluation()){
			employeeReminderList.add(properties.getProperty("INITIAL_COMPETENCY_REMINDER"));
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
		
		// Check the reminders for some fields only if Department code is 200
		if(null != employeeInfo.getDepartment() && "200".equalsIgnoreCase(employeeInfo.getDepartment())){
			if(null == employeeInfo.getProfLicense() || !employeeInfo.getProfLicense().after(currentcal.getTime())){
				employeeReminderList.add(properties.getProperty("PROF_LICENSE_REMINDER"));
			}
			
			if(null == employeeInfo.getCprCard() || !employeeInfo.getCprCard().after(currentcal.getTime())){
				employeeReminderList.add(properties.getProperty("CPR_REMINDER"));
			}
			
			if(null == employeeInfo.getTbTest() || !employeeInfo.getTbTest().after(currentcal.getTime())){
				employeeReminderList.add(properties.getProperty("TBTEST_REMINDER"));
			}

			if(null == employeeInfo.getHippaTraining() || employeeInfo.getHippaTraining() =='N'){
				employeeReminderList.add(properties.getProperty("HIPPA_REMINDER"));
			}
			 
			if(null == employeeInfo.getOshaTraining() || employeeInfo.getOshaTraining() =='N'){
				employeeReminderList.add(properties.getProperty("OSHA_REMINDER"));
			}
			
			if(null == employeeInfo.getVerificationProfLicense() || employeeInfo.getVerificationProfLicense() =='N'){
				employeeReminderList.add(properties.getProperty("VERIFICATION_OF_PROF_LICENSE_REMINDER"));
			}
			
			if(null == employeeInfo.getHvbTest() || employeeInfo.getHvbTest() =='N'){
				employeeReminderList.add(properties.getProperty("HVBTEST_REMINDER"));
			} 
			
		}
		
		if(null == employeeInfo.getProofValidCarInsurance() || !employeeInfo.getProofValidCarInsurance().after(currentcal.getTime())){
			employeeReminderList.add(properties.getProperty("PROOF_OF_CAR_INSURANCE_REMINDER"));
		}
		
		if(null == employeeInfo.getDriversLicense() || !employeeInfo.getDriversLicense().after(currentcal.getTime())){
			employeeReminderList.add(properties.getProperty("DRIVERS_LICENSE_REMINDER"));
		}
		
		
				
		return employeeReminderList;
	}
}
