package com.homecare.bo;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.homecare.domain.Patient;

@Transactional
public interface PatientBO {
	public List<Patient> getPatients();
	public void updatePatient(List<Patient> patients);
}
