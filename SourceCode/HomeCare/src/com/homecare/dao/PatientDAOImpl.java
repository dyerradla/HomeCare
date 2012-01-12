package com.homecare.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.homecare.domain.Patient;
import com.homecare.domain.Patient_Audit;

public class PatientDAOImpl extends BaseDAO implements PatientDAO{

	public List<Patient> getPatients() {
		System.out.println("**********Inside test method of TestDAOImpl***************");
		Criteria criteria = getSession().createCriteria(Patient.class);
		criteria.add(Restrictions.eq("patientId", "123"));
		List<Patient> patientList = criteria.list();
		return patientList;
	}
	
	public void updatePatient(List<Patient> patients){
		if(null != patients && !patients.isEmpty()){
			for(Patient patient : patients){
				Criteria criteria = getSession().createCriteria(Patient.class);
				criteria.add(Restrictions.eq("patientId", patient.getPatientId()));
				List<Patient> existingPatients = criteria.list();
				for(Patient existingPatient : existingPatients){
					Patient_Audit patientAudit = new Patient_Audit(existingPatient);
					saveObject(patientAudit);
				}
				mergeObjects(patient);
				
			}
		}
	}
}
