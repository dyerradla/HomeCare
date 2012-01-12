package com.homecare.dao;

import java.util.List;

import com.homecare.domain.Patient;

public interface PatientDAO {
	public List<Patient> getPatients();
	
	public void updatePatient(List<Patient> patients);
}
