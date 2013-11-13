package com.homecare.bo;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.validator.Email;
import org.springframework.beans.factory.annotation.Autowired;

import com.homecare.dao.IEmployerDAO;
import com.homecare.dao.IUserDAO;
import com.homecare.domain.EmployerInfo;
import com.homecare.domain.User;
import com.homecare.utility.EmailUtility;

public class UserBOImpl implements IUserBO {

	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private IEmployeeInfoBO employeeInfoBO;
	
	@Autowired
	private IEmployerDAO employerDAO;
	public User validateUser(String userName, String password) {
		return userDAO.validateUser(userName, password);
	}
	
	public void saveUser(User user){
		userDAO.saveUser(user);
	}
	
	public EmployerInfo loadEmployer(Long employerId){
		return employerDAO.getEmployerInfo(employerId);
	}
	
	public void saveEmployer(EmployerInfo employerInfo){
		Map<String, String> messagesMap = employeeInfoBO.getMessageMapByType("SEND_EMAIL");
		
		String email = employerInfo.getEmail();
		String emailType = null;
		String hostName = "";
		String port = "";
		if(null != email){
			Pattern pattern = Pattern.compile("@(\\S+)\\.\\w+");
			Matcher matcher = pattern.matcher(email);
			while (matcher.find()) {
			      emailType = matcher.group(1);
			}
			
			String hostNamePort = messagesMap.get(emailType);
			if(null != hostNamePort){
				String[] hostNamePortArray = hostNamePort.split("_");
				hostName = hostNamePortArray[0];
				port = hostNamePortArray[1];
			}
		}
		
		employerInfo.setSmtphost(hostName);
		employerInfo.setPort(port);
		employerDAO.saveEmployer(employerInfo);
	}
	
	public String sendPasswordEmail(String email){
		String status = "Your username and password send successfully to your email address";
		User user = userDAO.findUserByEmail(email);
		
		// User Found we will be sending the Email
		if(null != user){
			StringBuffer body = new StringBuffer("Hi "+user.getLastName()+" "+user.getFirstName()+",\n");
			body.append("<table><tr><td>Please find the following user name and password</td></tr>");
			body.append("<tr><td> User Name :"+ user.getUserName()+"</td></tr>");
			body.append("<tr><td> Password :"+ user.getPassword()+"</td></tr>");
			body.append("</table>");
			EmailUtility emailUtility = new EmailUtility();
			emailUtility.sendEmail("Forgot UserName/Password", email, body.toString(), null);
		}else{
			status = "No User found with given email address";
		}
		return status;
	}
}
