package com.homecare.domain;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "employee_documents", catalog = "homecare")
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_NAME", unique = true, nullable = false)
	private Long documentId;
	
	@Column(name = "employeeId")
	private Long employeeId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "document")
	@Lob
	private Blob document;
	
	@Column(name = "document_name")
	private String documentName;
	
	
	public Long getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Blob getDocument() {
		return document;
	}
	public void setDocument(Blob document) {
		this.document = document;
	}
	
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
}
