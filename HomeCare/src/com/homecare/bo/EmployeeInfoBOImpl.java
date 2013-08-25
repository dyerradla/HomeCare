package com.homecare.bo;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import com.homecare.dao.IEmployeeDAO;
import com.homecare.dao.IEmployerDAO;
import com.homecare.domain.CodeValue;
import com.homecare.domain.EmployeeInfo;
import com.homecare.domain.EmployerEmailInfo;
import com.homecare.domain.EmployerInfo;
import com.homecare.utility.EmailUtility;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.pdf.PdfWriter;

public class EmployeeInfoBOImpl implements IEmployeeInfoBO {
	
	private Log logger = LogFactory.getLog(EmployeeInfoBOImpl.class);
	@Autowired
	private IEmployeeDAO employeeDAO;

	@Autowired
	private IEmployerDAO employerDAO;

	
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

	@Scheduled(cron="0 0 1 * * ?")
	@Async
	public void generateEmail(){
		System.out.println("*****Generate Email");
		EmployeeInfo employeeInfoRequest = new EmployeeInfo();
		employeeInfoRequest.setStatus("A");
		List<EmployeeInfo> employeeInfoList = employeeDAO.getAllEmployees(employeeInfoRequest);
		if(null != employeeInfoList){
			for(EmployeeInfo employeeInfo : employeeInfoList){
				sendEmail(employeeInfo.getEmployeeId());
			}
		}
	}
	
	@Scheduled(cron="0 0 1 * * ?")
	@Async
	public void generatePDFAndEmailForAllActiveEmployees(){
		System.out.println("************************************Print All the Reminders");
	    EmployeeInfo employeeInfoRequest = new EmployeeInfo();
		employeeInfoRequest.setStatus("A");
		List<EmployeeInfo> employeeList = employeeDAO.getAllEmployees(employeeInfoRequest);
		Map<Long,List<EmployeeInfo>> employeeListMap = getEmployeeListMap(employeeList);
		for(Long employerId : employeeListMap.keySet()){
			List<EmployeeInfo> employees = employeeListMap.get(employerId);
			Document document = new Document(); 
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			try {
				PdfWriter.getInstance(document, out);        
				document.open();     
				if(null != employees){
					for(EmployeeInfo employeeInfo : employees){
						List<String> reminders = getRemindersByEmployee(employeeInfo);
						com.itextpdf.text.List list = new com.itextpdf.text.List();
						if(reminders != null && !reminders.isEmpty()){
							document.add(new Chunk(employeeInfo.getLastName() + " " + employeeInfo.getFirstName()));
							for(String reminder : reminders){
								// Add the list items to list        
								list.add(new ListItem(reminder));      
							}
							document.add(list);
							document.newPage();
						}
					} 
				}
				document.close();
				
				List<EmployerEmailInfo> employerEmailList = employerDAO.getAllEmployerEmails(employerId);
				EmailUtility emailUtility = new EmailUtility();
				emailUtility.sendEmailWithAttachment("Reminders of all the employees", employerEmailList, out.toByteArray());		
			} catch (Exception e) {
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
	}
	
	private Map<Long,List<EmployeeInfo>> getEmployeeListMap(List<EmployeeInfo> employeeList){
		Map<Long,List<EmployeeInfo>> employeeListMap = new HashMap<Long, List<EmployeeInfo>>();
		if(null != employeeList){
			for(EmployeeInfo employeeInfo : employeeList){
				List<EmployeeInfo> employeeInfoList = employeeListMap.get(employeeInfo.getEmployerId());
				if(null == employeeInfoList){
					employeeInfoList = new ArrayList<EmployeeInfo>();
					employeeListMap.put(employeeInfo.getEmployerId(), employeeInfoList);
				}
				employeeInfoList.add(employeeInfo);
			}
		}
		return employeeListMap;
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
		EmployerInfo employerInfo = employerDAO.getEmployerInfo(employeeInfo.getEmployerId());
		List<String> employeeReminderList = getRemindersByEmployee(employeeInfo);
		// Send an email
		String concatenatedReminderString ="<table>";
		for(String remiderString : employeeReminderList){
			concatenatedReminderString += "<tr><td>"+remiderString + "\n\n</td></tr>";
		}
		concatenatedReminderString += "</table>";
		if(!employeeReminderList.isEmpty()){
			EmailUtility emailUtility = new EmailUtility();
			emailUtility.sendEmail("Reminders", employeeInfo.getEmailAddress(), concatenatedReminderString,employerInfo);
		}
		return employeeInfo;
	}
	
	public List<EmployeeInfo> deleteEmployeeInfo(Long employeeId){
		employeeDAO.deleteEmployee(employeeId);
		return getAllEmployees(new EmployeeInfo());
	}
	
	public Map<String,EmployeeInfo> getAllReminders(Long employerId) {
		EmployeeInfo employeeInfo = new EmployeeInfo();
		employeeInfo.setStatus("A");
		employeeInfo.setEmployerId(employerId);
		List<EmployeeInfo> employeeList = employeeDAO.getAllEmployees(employeeInfo);
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
				employeeInfo.setEmployeeReminderMessage(employeeReminderList);
				employeeRemindersMap.put(employeeInfo.getLastName()+" "+employeeInfo.getMiddleName() + " "+employeeInfo.getFirstName(),
						employeeInfo);
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
		Map<String,String> messagesMap = getMessageMapByType("R");
		
		Calendar currentcal = Calendar.getInstance();
		currentcal.add(Calendar.DATE, 15);
//		currentcal.add(Calendar.MONTH, 1);
		
		Calendar annualEvaluation = Calendar.getInstance();
		annualEvaluation.add(Calendar.YEAR, -1);
		annualEvaluation.add(Calendar.DATE, 15);
//		annualEvaluation.add(Calendar.MONTH, 1);
		
		List<String> employeeReminderList = new ArrayList<String>();
		// Check the reminders for some fields only if Department code is not 300
		if(null != employeeInfo.getDepartment() && !"300".equalsIgnoreCase(employeeInfo.getDepartment())){
			if(null == employeeInfo.getApplication() || employeeInfo.getApplication() == 'N'){
				employeeReminderList.add(messagesMap.get("APPLICATION_REMINDER"));
			}
			
			if(null == employeeInfo.getResume() || employeeInfo.getResume() =='N'){
				employeeReminderList.add(messagesMap.get("RESUME_REMINDER"));
			}
			
			if(null == employeeInfo.getReferenceChecks() || employeeInfo.getReferenceChecks() == 'N'){
				employeeReminderList.add(messagesMap.get("REFERENCES_CHECK_REMINDER"));
			}
			
			if(null == employeeInfo.getStatementOfConfidentiality() || employeeInfo.getStatementOfConfidentiality() =='N'){
				employeeReminderList.add(messagesMap.get("STATEMENT_OF_CONFIDENTIALITY_REMINDER"));
			}
			
			if(null == employeeInfo.getPolicy() || employeeInfo.getPolicy() =='N'){
				employeeReminderList.add(messagesMap.get("POLICY_REMINDER"));
			}
			
			if(null == employeeInfo.getSocialSecurityCard() || employeeInfo.getSocialSecurityCard() =='N'){
				employeeReminderList.add(messagesMap.get("SSN_REMINDER"));
			}
			
			if(null == employeeInfo.getNonCompete() || employeeInfo.getNonCompete() =='N'){
				employeeReminderList.add(messagesMap.get("NON_COMPETE_REMINDER"));
			}
			 
			if(null == employeeInfo.getAuthorizationCriminalCheck() || employeeInfo.getAuthorizationCriminalCheck() =='N'){
				employeeReminderList.add(messagesMap.get("AUTHORIZATION_CRIMINAL_CHECK_REMINDER"));
			}
			
			if(null == employeeInfo.getCriminalCheck() || employeeInfo.getCriminalCheck() =='N'){
				employeeReminderList.add(messagesMap.get("CRIMINAL_CHECK_REMINDER"));
			}
			
			if(null == employeeInfo.getFingerprintsResults() || employeeInfo.getFingerprintsResults() =='N'){
				employeeReminderList.add(messagesMap.get("FINGER_PRINT_RESULTS_REMINDER"));
			}
			
			if(null == employeeInfo.getFederalW4() || employeeInfo.getFederalW4() =='N'){
				employeeReminderList.add(messagesMap.get("FEDERAL_W4_REMINDER"));
			} 
			 
			if(null == employeeInfo.getMichiganW4() || employeeInfo.getMichiganW4() =='N'){
				employeeReminderList.add(messagesMap.get("MICHIGAN_W4_REMINDER"));
			}
			
			if(null == employeeInfo.getI9() || employeeInfo.getI9() =='N'){
				employeeReminderList.add(messagesMap.get("I9_REMINDER"));
			}
		}
		
		if(null == employeeInfo.getSignedJobDescription() || employeeInfo.getSignedJobDescription() =='N'){
			employeeReminderList.add(messagesMap.get("SIGNED_JOB_REMINDER"));
		}
		
		if(null == employeeInfo.getOrientationChecklist() || employeeInfo.getOrientationChecklist() =='N'){
			employeeReminderList.add(messagesMap.get("ORIENTATION_CHECKLIST_REMINDER"));
		}
		
		Calendar employmentDate = Calendar.getInstance();
		Calendar currentDate = Calendar.getInstance();
		employmentDate.setTime(employeeInfo.getEmploymentDate());
		// The Reminder should come from 2 months
		employmentDate.add(Calendar.MONTH, 2);
		if(null == employeeInfo.getOngoinCompetencyEvaluation() 
				&& currentDate.getTime().after(employmentDate.getTime())){
			employeeReminderList.add(messagesMap.get("ONGOING_COMPETENCY_REMINDER"));
		}
		
		if(null == employeeInfo.getInitialCompetencyEvaluation()){
			employeeReminderList.add(messagesMap.get("INITIAL_COMPETENCY_REMINDER"));
		}

		if(null != employeeInfo.getAnnualEvaluation()){
			if(!employeeInfo.getAnnualEvaluation().after(annualEvaluation.getTime())){
				employeeReminderList.add(messagesMap.get("ANNUAL_EVALUTION_REMINDER"));
			}
		}else{
			if(!employeeInfo.getEmploymentDate().after(annualEvaluation.getTime())){
				employeeReminderList.add(messagesMap.get("ANNUAL_EVALUTION_REMINDER"));
			}
		}
		
		// Check the reminders for some fields only if Department code is not 100
		if(null != employeeInfo.getDepartment() && !"100".equalsIgnoreCase(employeeInfo.getDepartment())){
			if(null == employeeInfo.getProfLicense() || !employeeInfo.getProfLicense().after(currentcal.getTime())){
				employeeReminderList.add(messagesMap.get("PROF_LICENSE_REMINDER"));
			}
			
			if(null == employeeInfo.getCprCard() || !employeeInfo.getCprCard().after(currentcal.getTime())){
				employeeReminderList.add(messagesMap.get("CPR_REMINDER"));
			}
			
			if(null == employeeInfo.getTbTest() || !employeeInfo.getTbTest().after(currentcal.getTime())){
				employeeReminderList.add(messagesMap.get("TBTEST_REMINDER"));
			}

			if(null == employeeInfo.getOshaTraining() || employeeInfo.getOshaTraining() =='N'){
				employeeReminderList.add(messagesMap.get("OSHA_REMINDER"));
			}
			
			if(null == employeeInfo.getVerificationProfLicense() || employeeInfo.getVerificationProfLicense() =='N'){
				employeeReminderList.add(messagesMap.get("VERIFICATION_OF_PROF_LICENSE_REMINDER"));
			}
			
			if(null == employeeInfo.getHvbTest() || employeeInfo.getHvbTest() =='N'){
				employeeReminderList.add(messagesMap.get("HVBTEST_REMINDER"));
			} 
			
		}
		
		if(null == employeeInfo.getHippaTraining() || employeeInfo.getHippaTraining() =='N'){
			employeeReminderList.add(messagesMap.get("HIPPA_REMINDER"));
		}
		if(null == employeeInfo.getProofValidCarInsurance() || !employeeInfo.getProofValidCarInsurance().after(currentcal.getTime())){
			employeeReminderList.add(messagesMap.get("PROOF_OF_CAR_INSURANCE_REMINDER"));
		}
		
		if(null == employeeInfo.getDriversLicense() || !employeeInfo.getDriversLicense().after(currentcal.getTime())){
			employeeReminderList.add(messagesMap.get("DRIVERS_LICENSE_REMINDER"));
		}
				
		return employeeReminderList;
	}

	public Map<String, String> getMessageMapByType(String type) {
		Map<String,String> messageMap = new HashMap<String,String>();
		List<CodeValue> codeValues = employeeDAO.getMessageMapByType(type);
		if(null != codeValues){
			for(CodeValue codeValue : codeValues){
				messageMap.put(codeValue.getCode(), codeValue.getValue());
			}
		}
		return messageMap;
	}
}
