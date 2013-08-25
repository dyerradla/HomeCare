package com.homecare.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "employer_email_Info", catalog = "homecare")
public class EmployerEmailInfo {

	private JoinedEmailEmployerId joinedEmailEmployerId;
	private String primary;
	private EmployerInfo employerInfo;
	
	@EmbeddedId
	public JoinedEmailEmployerId getJoinedEmailEmployerId() {
		return joinedEmailEmployerId;
	}
	public void setJoinedEmailEmployerId(JoinedEmailEmployerId joinedEmailEmployerId) {
		this.joinedEmailEmployerId = joinedEmailEmployerId;
	}
		
	@Column(name="primary",nullable = false)
	public String getPrimary() {
		return primary;
	}
	public void setPrimary(String primary) {
		this.primary = primary;
	}
	
	@Transient
	public EmployerInfo getEmployerInfo() {
		return employerInfo;
	}
	public void setEmployerInfo(EmployerInfo employerInfo) {
		this.employerInfo = employerInfo;
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