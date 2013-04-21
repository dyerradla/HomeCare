package com.homecare.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;

@Controller
public class BaseFormController implements ApplicationContextAware{
	protected ApplicationContext applicationContext;
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;		
	}
	
	
	protected Map referenceData() {
		 
		Map referenceData = new HashMap();
 
		Map<Character,String> yesNoMap = new LinkedHashMap<Character,String>();
		yesNoMap.put('Y', "Yes");
		yesNoMap.put('N', "No");
		referenceData.put("yesNoList", yesNoMap);
 
		return referenceData;
	}

}
