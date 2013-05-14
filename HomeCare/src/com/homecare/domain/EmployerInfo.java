package com.homecare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employer", catalog = "homecare")
public class EmployerInfo {

	private JoinedEmailEmployerId joinedEmailEmployerId;
	private String employerName;
	private String primary;
	
	@EmbeddedId
	public JoinedEmailEmployerId getJoinedEmailEmployerId() {
		return joinedEmailEmployerId;
	}
	public void setJoinedEmailEmployerId(JoinedEmailEmployerId joinedEmailEmployerId) {
		this.joinedEmailEmployerId = joinedEmailEmployerId;
	}
	@Column(name="employer_name")
	public String getEmployerName() {
		return employerName;
	}
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}
	
	@Column(name="primary",nullable = false)
	public String getPrimary() {
		return primary;
	}
	public void setPrimary(String primary) {
		this.primary = primary;
	}
	// required because JoinedUserRole contains composite id
    @Embeddable
    public static class JoinedEmailEmployerId implements Serializable {
    	
		private static final long serialVersionUID = 1L;
		private String employerId;
    	private String email;
    	
    	@Column(name="employer_id",nullable = false)
    	public String getEmployerId() {
    		return employerId;
    	}
    	public void setEmployerId(String employerId) {
    		this.employerId = employerId;
    	}
    	
    	@Column(name="email",nullable = false)
    	public String getEmail() {
    		return email;
    	}
    	public void setEmail(String email) {
    		this.email = email;
    	}	
    }
}