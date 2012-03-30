package com.homecare.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class HomeController extends BaseFormController{
	
	@RequestMapping("/home")
	public ModelAndView loadHomeScreen(){
		return new ModelAndView("home");
	}

}
