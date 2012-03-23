package com.homecare.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.homecare.bo.IEmployeeInfoBO;
import com.homecare.domain.EmployeeInfo;

@Controller
public class EmployeeController extends BaseFormController{
	
	@Autowired
	private IEmployeeInfoBO employeeInfoBO;
	
	@RequestMapping("/employeeInfo")
	public ModelAndView test(){
		System.out.println("**********Inside Employee Controller******");
		List<EmployeeInfo> employeeList = new ArrayList<EmployeeInfo>();
		EmployeeInfo empInfo = new EmployeeInfo();
		empInfo.setFirstName("First");
		empInfo.setLastName("Last");
		empInfo.setMiddleName("Middle");
		empInfo.setCreateDt(new Date());
		empInfo.setCreateUserId("testUser");
		employeeList.add(empInfo);
		
		ModelAndView modelAndView = new ModelAndView("default"); 
		modelAndView.addObject("employeeInfo", employeeList);
		return modelAndView;
	}
	
	@RequestMapping("/saveEmployeeInfo")
	public ModelAndView saveData(){
		System.out.println("*******************Inside Save Employee Info");
		ModelAndView modelAndView = new ModelAndView("default"); 
		return modelAndView;
	}
}

