package com.examples.spring.web.mvc.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.examples.spring.web.mvc.model.Register;
import com.examples.spring.web.mvc.service.RegisterService;

/**
 * Handles requests for the employee management.
 */
@Controller
@RequestMapping(value = "/registers")
public class RegisterController {

	@Autowired
	RegisterService regService;

	public RegisterService getRegService() {
		return regService;
	}

	public void setRegService(RegisterService regService) {
		this.regService = regService;
	}

	@ModelAttribute("genderOptions")
	public Map<String, String> getGenderOptions() {
		Map<String, String> genderOptions = new LinkedHashMap<String, String>();
		genderOptions.put("M", "Male");
		genderOptions.put("F", "Female");
		return genderOptions;
	}

	@ModelAttribute("countries")
	public Map<String, String> getCountries() {
		Map<String, String> getCountries = new LinkedHashMap<String, String>();
		getCountries.put("India", "India");
		getCountries.put("USA", "USA");
		getCountries.put("UK", "UK");
		getCountries.put("China", "China");
		return getCountries;
	}

	@ModelAttribute("skillList")
	public List<String> getSkills() {
		List<String> skillList = new ArrayList();
		skillList.add("Technical");
		skillList.add("Functional");
		skillList.add("Managerial");
		skillList.add("Process");
		return skillList;
	}
	

	@ModelAttribute("user")
	public Register creatEmployeeModel() {
		return new Register();
	}

	@GetMapping
	public ModelAndView showAddForm() {

		return new ModelAndView("register");
	}


	@PostMapping()
	public String addUser(@ModelAttribute("user") @Valid Register user,BindingResult result) {
   
		if (result.hasErrors()) {
			return "register";
		}

		regService.add(user);
		
		return "redirect:/login";

	}

}
