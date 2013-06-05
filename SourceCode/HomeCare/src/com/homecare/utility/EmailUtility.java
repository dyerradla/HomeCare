package com.homecare.utility;

import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.homecare.domain.EmployerEmailInfo;
import com.homecare.domain.EmployerSendEmail;

public class EmailUtility {
	private Log logger = LogFactory.getLog(EmailUtility.class);
	String emailUserName = "peddyb@paragonhhc.com";
	String password = "madhup";
	String smtphost = "smtpout.secureserver.net";
	String port = "80";
	public void sendEmail(String subject,String email,String body,EmployerSendEmail employerSendEmail){
		if(isDataExists(employerSendEmail)){
			emailUserName = employerSendEmail.getEmail();
			password = employerSendEmail.getPassword();
			smtphost = employerSendEmail.getSmtphost();
			port = employerSendEmail.getPort();
		}
		final String authenticationUserName = emailUserName;
		final String authenticationPassword = password;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", smtphost);
		props.put("mail.smtp.port", port);
		
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(authenticationUserName,authenticationPassword);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailUserName));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(email));
			message.setSubject(subject);
			message.setText(body);
			
			message.setContent(body, "text/html; charset=utf-8");
			Transport.send(message);
 
			System.out.println("Email Send");
 
		} catch (Exception e) {
			logger.error("Exception Occured in Sending an email", e);
		}
	}

	public void sendEmailWithAttachment(String subject,List<EmployerEmailInfo> employerEmailList,byte[] data){
		if(null != employerEmailList && !employerEmailList.isEmpty()){
			EmployerSendEmail employerSendEmail = employerEmailList.get(0).getEmployerSendEmail();
			if(isDataExists(employerSendEmail)){
				emailUserName = employerSendEmail.getEmail();
				password = employerSendEmail.getPassword();
				smtphost = employerSendEmail.getSmtphost();
				port = employerSendEmail.getPort();
			}
			final String authenticationUserName = emailUserName;
			final String authenticationPassword = password;
			
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", smtphost);
			props.put("mail.smtp.port", port);
			
			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(authenticationUserName, authenticationPassword);
				}
			  });
	 
			try {
	 
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(emailUserName));
				for(EmployerEmailInfo employerInfo : employerEmailList){
					if("Y".equalsIgnoreCase(employerInfo.getPrimary())){
						message.setRecipients(Message.RecipientType.TO,
								InternetAddress.parse(employerInfo.getJoinedEmailEmployerId().getEmail()));
					}else{
						message.setRecipients(Message.RecipientType.CC,
								InternetAddress.parse(employerInfo.getJoinedEmailEmployerId().getEmail()));
					}
				}
				
				message.setSubject(subject);
				
				 //construct the text body part        
				MimeBodyPart textBodyPart = new MimeBodyPart();          
				textBodyPart.setText("Please find the attachment with the reminders of all the employees");
					
				//construct the pdf body part          
				DataSource dataSource = new ByteArrayDataSource(data, "application/pdf;charset=UTF-8");    
				MimeBodyPart pdfBodyPart = new MimeBodyPart();       
				pdfBodyPart.setDataHandler(new DataHandler(dataSource));
				pdfBodyPart.setFileName("reminders.pdf");                                
				
				//construct the mime multi part            
				MimeMultipart mimeMultipart = new MimeMultipart();         
				mimeMultipart.addBodyPart(textBodyPart);           
				mimeMultipart.addBodyPart(pdfBodyPart);
				
				message.setContent(mimeMultipart);
				Transport.send(message);
	 
				System.out.println("Email Send");
	 
			} catch (Exception e) {
				logger.error("Exception Occured in Sending an email", e);
			}
		}
	}
	
	private boolean isDataExists(EmployerSendEmail employerSendEmail){
		boolean isDataExists= false;
		if(null != employerSendEmail 
				&& null != employerSendEmail.getEmail() 
				&& null != employerSendEmail.getPort() 
				&& null != employerSendEmail.getPassword() 
				&& null != employerSendEmail.getSmtphost()){
			isDataExists = true;
		}
		return isDataExists;
	}
	
}
