package com.homecare.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.homecare.bo.IUserBO;
import com.homecare.command.UserForm;
import com.homecare.domain.EmployerInfo;
import com.homecare.domain.User;

@Controller
public class UserController extends BaseFormController {
	
	@Autowired
	public IUserBO userBO;
	
	@RequestMapping("/saveUser")
	public ModelAndView saveUser(@ModelAttribute("command") UserForm userForm,HttpServletRequest httpServletRequest){
		ModelAndView modelAndView = new ModelAndView("userInfo");
		userBO.saveUser(userForm.getUser());
		return modelAndView;
	}
	
	@RequestMapping("/createUser")
	public ModelAndView createUser(@ModelAttribute("command") UserForm userForm,HttpServletRequest httpServletRequest){
		ModelAndView modelAndView = new ModelAndView("userInfo");
		return modelAndView;
	}
	
	@RequestMapping("/editUser")
	public ModelAndView editUser(@ModelAttribute("command") UserForm userForm,HttpServletRequest httpServletRequest){
		ModelAndView modelAndView = new ModelAndView("userInfo");
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		userForm.setUser(user);
		return modelAndView;
	}
	
	@RequestMapping("/editEmployerInfo")
	public ModelAndView editEmployerInfo(@ModelAttribute("command") UserForm userForm,HttpServletRequest httpServletRequest){
		ModelAndView modelAndView = new ModelAndView("employerInfo");
		User user = (User)httpServletRequest.getSession().getAttribute("user");
		EmployerInfo employerInfo = new EmployerInfo();
		if(null != user && null != user.getEmployerId()){
			employerInfo = userBO.loadEmployer(user.getEmployerId());
		}
		userForm.setEmployerInfo(employerInfo);
		return modelAndView;
	}
	
	@RequestMapping("/saveEmployer")
	public ModelAndView saveEmployer(@ModelAttribute("command") UserForm userForm,HttpServletRequest httpServletRequest){
		ModelAndView modelAndView = new ModelAndView("employerInfo");
		userBO.saveEmployer(userForm.getEmployerInfo());
		return modelAndView;
	}
	
}
