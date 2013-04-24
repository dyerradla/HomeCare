package com.homecare.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.homecare.bo.IUserBO;
import com.homecare.command.EmployeeInfoForm;
import com.homecare.command.UserForm;
import com.homecare.domain.EmployeeInfo;

@Controller
public class LoginController extends BaseFormController{
	
	@Autowired
	private IUserBO userBO;
	
	@Autowired
	private EmployeeController employeeController;
	
	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute("command") UserForm userForm, HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws ServletException, IOException{
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(@ModelAttribute("command") UserForm userForm, HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws ServletException, IOException{
		if(null != httpServletRequest.getSession()){
			httpServletRequest.getSession().removeAttribute("user");
		}
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@RequestMapping("/validateUser")
	public ModelAndView validateUser(@ModelAttribute("command") UserForm userForm, HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws ServletException, IOException{
		boolean validUser = false;
		if(null != userForm.getUser()){
			validUser = userBO.validateUser(userForm.getUser().getUserName(), userForm.getUser().getPassword());
		}
		
		ModelAndView modelAndView = null; 
		if(validUser){
			httpServletRequest.getSession().setAttribute("user", userForm.getUser());
			EmployeeInfoForm employeeInfoForm = new EmployeeInfoForm();
			employeeInfoForm.setEmployeeInfo(new EmployeeInfo());
			httpServletRequest.getRequestDispatcher("getAllEmployees.do").forward(httpServletRequest, httpServletResponse);
		}else{
			userForm.setValidUser("N");
			modelAndView = new ModelAndView("login");
			userForm.setUser(userForm.getUser());
		}
		return modelAndView;
	}
}

