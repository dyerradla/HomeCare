package com.homecare.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.homecare.dao.PatientDAO;
import com.homecare.domain.Patient;

public class PatientBOImpl implements PatientBO{
	@Autowired
	private PatientDAO patientDAO;
	public List<Patient> getPatients() {
		System.out.println("**********Inside test method of TestBOImpl***************");
		return patientDAO.getPatients();
	}
	
	public void updatePatient(List<Patient> patients){
		patientDAO.updatePatient(patients);
	}
	
}
