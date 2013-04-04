package com.homecare.utility;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EmailUtility {
	private Log logger = LogFactory.getLog(EmailUtility.class);
	public void sendEmail(String subject,String email,String body){
		final Properties emailProperties = new Properties();
		try {
			emailProperties.load(this.getClass().getResourceAsStream("/email.properties"));
		} catch (IOException e) {
			logger.error("Properties File not found");
		}
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", emailProperties.getProperty("EMAIl_STMP_SERVER_HOST"));
		props.put("mail.smtp.port", emailProperties.getProperty("EMAIL_STMP_PORT"));
		
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailProperties.getProperty("EMAIL_USER_NAME"), emailProperties.getProperty("EMAIl_PASSWORD"));
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailProperties.getProperty("EMAIL_USER_NAME")));
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
}
