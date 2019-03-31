package com.examples.spring.web.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.examples.spring.web.mvc.exception.LoginException;
import com.examples.spring.web.mvc.model.Login;
import com.examples.spring.web.mvc.model.Register;
import com.examples.spring.web.mvc.service.RegisterService;

/**
 * Handles requests for the application login page.
 */
@Controller
@SessionAttributes("userName")
public class LoginController {
	@Autowired
	RegisterService regService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)	
	public ModelAndView login(Model model) {

		return new ModelAndView("login", "command", new Login());
	}
	
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	@ExceptionHandler(LoginException.class)
	public ModelAndView authenticate(@ModelAttribute @Valid Login login,BindingResult bindingResult, Model model, HttpSession session) {
		List<Register> list=new ArrayList<Register>();
		list=regService.list();
		if(bindingResult.hasErrors()){ 
		for(Register l:list) {
			if(login.getUserName().equalsIgnoreCase(l.getUserName()) && login.getPassword().equalsIgnoreCase(l.getPassWord()))
			{
//				logger.info("Authentication success");
//				session.setAttribute("userName", login.getUserName());
				model.addAttribute("userName", "admin");
				return new ModelAndView("redirect:/employee/list");
			}
			}
		}
		
		return new ModelAndView("redirect:/register");
		
		
	}
	
	public List<Login> getUsers()
	{
		List<Login> users = new ArrayList<Login>();
		users.add(new Login("admin","admin@123"));
		users.add(new Login("manager", "manager@123"));
		users.add(new Login("user", "user@123"));
	
		return users;
	}
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, SessionStatus sessionStatus)
	{		
		sessionStatus.setComplete();
//		session.removeAttribute("userName");		
//		session.invalidate();
		return "redirect:/";
	}
}