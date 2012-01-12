package com.homecare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.homecare.bo.PatientBO;
import com.homecare.domain.Patient;

@Controller
public class PatientController extends BaseFormController{
	
	@Autowired
	private PatientBO patientBO;
	
	@RequestMapping("/patientInfo")
	public ModelAndView test(){
		System.out.println("**********Inside test Controller******");
		List<Patient> patientList = patientBO.getPatients();
		
		patientList.get(0).setFirstName(patientList.get(0).getFirstName()+"p");
		patientBO.updatePatient(patientList);
		
		patientList = patientBO.getPatients();
		ModelAndView modelAndView = new ModelAndView("default"); 
		modelAndView.addObject("patients", patientList);
		return modelAndView;
	}
	
	@RequestMapping("/savePatientInfo")
	public ModelAndView saveData(){
		System.out.println("*******************Inside Save Patient Info");
		ModelAndView modelAndView = new ModelAndView("default"); 
		return modelAndView;
	}
}
