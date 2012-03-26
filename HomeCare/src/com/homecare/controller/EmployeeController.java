package com.homecare.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	
	@InitBinder
	public void initBinder(final WebDataBinder binder){
		final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping("/employeeInfo")
	public ModelAndView getEmployeeInformation(@ModelAttribute("command") EmployeeInfoForm employeeInfoForm,HttpServletRequest httpServletRequest){
		System.out.println("**********Inside Employee Controller******");
		EmployeeInfo empInfo = employeeInfoBO.getEmployeeInfo(new Long(1));
		ModelAndView modelAndView = new ModelAndView("employeeInfo"); 
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
		EmployeeInfo employeeInfo = employeeInfoForm.getEmployeeInfo();
		employeeInfo.setCreateUserId("1");
		employeeInfoBO.updateEmployeeInfo(employeeInfo);
		ModelAndView modelAndView = new ModelAndView("default"); 
		return modelAndView;
	}
}

