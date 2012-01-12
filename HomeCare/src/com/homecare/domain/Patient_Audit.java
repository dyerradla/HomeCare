package com.homecare.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "homecare.patient_audit")
public class Patient_Audit implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long auditId;
	private String patientId;
	private String firstName;
	private String middleName;
	private String lastName;
	private Date createDt;
	private String createUserId;
	private Date updateDt;
	private String updatedUserId;

	public Patient_Audit() {
	}
	
	public Patient_Audit(Patient patient) {
		patientId = patient.getPatientId();
		firstName = patient.getFirstName();
		middleName = patient.getMiddleName();
		lastName = patient.getLastName();
		createDt = patient.getCreateDt();
		createUserId = patient.getCreateUserId();
		updateDt = new Date();
		updatedUserId = null;
	}
	
	
	@Id
	@Column(name="Audit_Id")
	public Long getAuditId() {
		return auditId;
	}

	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}

	@Column(name = "Patient_id")
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	
	@Column(name = "First_Name")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "Middle_Name")
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	@Column(name = "Last_Name")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "Create_Dt")
	public Date getCreateDt() {
		return createDt;
	}
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	
	@Column(name = "Create_User_Id")
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	
	@Column(name="Update_Dt")
	public Date getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}
	
	@Column(name="Update_User_Id")
	public String getUpdatedUserId() {
		return updatedUserId;
	}
	public void setUpdatedUserId(String updatedUserId) {
		this.updatedUserId = updatedUserId;
	}
}
