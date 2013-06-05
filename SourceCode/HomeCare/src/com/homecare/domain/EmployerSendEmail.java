package com.homecare.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employer_send_email", catalog = "homecare")
public class EmployerSendEmail {
	private Long employerSendEmailId;
	private Long employerId;
	private String email;
	private String password;
	private String smtphost;
	private String port;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false)
	public Long getEmployerSendEmailId() {
		return employerSendEmailId;
	}
	public void setEmployerSendEmailId(Long employerSendEmailId) {
		this.employerSendEmailId = employerSendEmailId;
	}
	
	@Column(name="employer_id", nullable = false)
	public Long getEmployerId() {
		return employerId;
	}
	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}
	
	@Column(name="email", nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Column(name="password", nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="smtphost", nullable = false)
	public String getSmtphost() {
		return smtphost;
	}
	public void setSmtphost(String smtphost) {
		this.smtphost = smtphost;
	}
	
	@Column(name="port", nullable = false)
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
}