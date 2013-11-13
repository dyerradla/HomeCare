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
import org.springframework.web.servlet.view.RedirectView;

import com.homecare.bo.IUserBO;
import com.homecare.command.EmployeeInfoForm;
import com.homecare.command.UserForm;
import com.homecare.domain.EmployeeInfo;
import com.homecare.domain.User;

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
		User validUser = new User();
		if(null != userForm.getUser()){
			validUser = userBO.validateUser(userForm.getUser().getUserName(), userForm.getUser().getPassword());
		}
		
		ModelAndView modelAndView = null; 
		if(validUser.isValidUser()){
			httpServletRequest.getSession().setAttribute("user", validUser);
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
	
	@RequestMapping("/forgotPassword")
	public ModelAndView forgotPassword(@ModelAttribute("command") UserForm userForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
		return new ModelAndView("forgotPassword");
	}
	
	@RequestMapping("/sendPasswordEmail")
	public ModelAndView sendPasswordEmail(@ModelAttribute("command") UserForm userForm, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
		String status = userBO.sendPasswordEmail(userForm.getEmail());
		userForm.setStatus(status);
		System.out.println("Status**********"+status);
		return new ModelAndView("forgotPassword");
	}
}

