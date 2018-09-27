package com.joseph.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.Employer;
import com.spring.service.EmployerService;

@Controller
public class EmployerController {
	@Autowired
	private EmployerService employerService;
	
	@RequestMapping("/index")
	public String setupForm(Map<String, Object> map){
		Employer employer = new Employer();
		map.put("employer", employer);
		map.put("employerList", employerService.getAllEmployer());
		return "employer";
	}
	@RequestMapping(value="/employer.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Employer employer, BindingResult result, @RequestParam String action, Map<String, Object> map){
		Employer employerResult = new Employer();
		switch(action.toLowerCase()){	//only in Java7 you can put String in switch
		case "add":
			employerService.add(employer);
			employerResult = employer;
			break;
		case "edit":
			employerService.edit(employer);
			employerResult = employer;
			break;
		case "delete":
			employerService.delete(employer.getEmployerId());
			employerResult = new Employer();
			break;
		case "search":
			Employer searchedEmployer = employerService.getEmployer(employer.getEmployerId());
			employerResult = searchedEmployer!=null ? searchedEmployer : new Employer();
			break;
		}
		map.put("employer", employerResult);
		map.put("employerList", employerService.getAllEmployer());
		return "employer";
	}
}
