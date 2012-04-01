package com.homecare.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
	
	@RequestMapping("/getSelectedEmployeeInfo")
	public ModelAndView getSelectedEmployeeInfo(@ModelAttribute("command") EmployeeInfoForm employeeInfoForm,HttpServletRequest httpServletRequest){
		System.out.println("**********Inside Employee Controller******"+employeeInfoForm.getSelectedEmployeeLastName());
		employeeInfoForm.getEmployeeInfo().setLastName(employeeInfoForm.getSelectedEmployeeLastName());
		EmployeeInfo empInfo = employeeInfoBO.getEmployeeInfo(employeeInfoForm.getEmployeeInfo());
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
	
	@RequestMapping("/loadEmployeeInfo")
	public ModelAndView getEmployeeInfo(@ModelAttribute("command") EmployeeInfoForm employeeInfoForm,HttpServletRequest httpServletRequest){
		System.out.println("*******Load Employee Info**************");
		EmployeeInfo empInfo = new EmployeeInfo();
		ModelAndView modelAndView = new ModelAndView("employeeInfo"); 
		employeeInfoForm.setEmployeeInfo(empInfo);
		return modelAndView;
	}
	
	@RequestMapping("/saveEmployeeInfo")
	public ModelAndView saveData(@ModelAttribute("command") EmployeeInfoForm employeeInfoForm,HttpServletRequest httpServletRequest) throws Exception{
		System.out.println("*******************Inside Save Employee Info");
		EmployeeInfo employeeInfo = employeeInfoForm.getEmployeeInfo();
		employeeInfo.setCreateUserId("1");
		employeeInfo.setEmployeeId(new Long(12));
		employeeInfoBO.updateEmployeeInfo(employeeInfo);
		ModelAndView modelAndView = new ModelAndView("home"); 
		return modelAndView;
	}
	
	@RequestMapping("/getReminders")
	public ModelAndView getReminders(){
		Map<String,EmployeeInfo> employeeRemindersMap = employeeInfoBO.getAllReminders();
		ModelAndView modelAndView = new ModelAndView("employeeReminders"); 
		modelAndView.addObject("employeeReminders", employeeRemindersMap);
		return modelAndView;
	}
}

