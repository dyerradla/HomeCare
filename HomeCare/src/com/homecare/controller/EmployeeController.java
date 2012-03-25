package com.homecare.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.homecare.bo.IEmployeeInfoBO;
import com.homecare.command.EmployeeInfoForm;
import com.homecare.domain.EmployeeInfo;

@Controller
public class EmployeeController extends BaseFormController{
	
	@Autowired
	private IEmployeeInfoBO employeeInfoBO;
	
	@RequestMapping("/employeeInfo")
	public ModelAndView getEmployeeInformation(@ModelAttribute("command") EmployeeInfoForm employeeInfoForm,HttpServletRequest httpServletRequest){
		System.out.println("**********Inside Employee Controller******");
		List<EmployeeInfo> employeeList = new ArrayList<EmployeeInfo>();
		EmployeeInfo empInfo = new EmployeeInfo();
		empInfo.setFirstName("First");
		empInfo.setLastName("Last");
		empInfo.setMiddleName("Middle");
		empInfo.setCreateDt(new Timestamp(new Date().getTime()));
		empInfo.setCreateUserId("testUser");
		employeeList.add(empInfo);
		
		ModelAndView modelAndView = new ModelAndView("employeeInfo"); 
		modelAndView.addObject("employeeInfo", employeeList);
		employeeInfoForm.setEmployeeInfo(empInfo);
		return modelAndView;
	}
	
	
	@RequestMapping("/getAllEmployees")
	public ModelAndView getAllEmployees(){
		System.out.println("*******Get All Employees**************");
		List<EmployeeInfo> employeeList = employeeInfoBO.getAllEmployees();
		System.out.println("************Employee List**********"+employeeList.size());
		ModelAndView modelAndView = new ModelAndView("employeeList");
		modelAndView.addObject("employeeList", employeeList);
		return modelAndView;
	}
	
	@RequestMapping("/saveEmployeeInfo")
	public ModelAndView saveData(@ModelAttribute("command") EmployeeInfoForm employeeInfoForm,HttpServletRequest httpServletRequest) throws Exception{
		System.out.println("*******************Inside Save Employee Info");
		ModelAndView modelAndView = new ModelAndView("default"); 
		return modelAndView;
	}
}

