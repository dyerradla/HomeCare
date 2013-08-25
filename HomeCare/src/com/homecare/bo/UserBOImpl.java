package com.homecare.bo;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.homecare.dao.IEmployerDAO;
import com.homecare.dao.IUserDAO;
import com.homecare.domain.EmployerInfo;
import com.homecare.domain.User;

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
}
