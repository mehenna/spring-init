package com.mmi.review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mmi.review.service.LoginService;

@Controller
@SessionAttributes("name")
public class Logincontroller {

	private LoginService loginservice = (id, pw) -> id.equalsIgnoreCase("user")
														&& pw.equalsIgnoreCase("pw") ;
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLogin( ModelMap model) {
		return "login";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String showWelcom( ModelMap model, @RequestParam String name, @RequestParam String pw) {
		boolean authOk = loginservice.validate(name, pw);
		if (!authOk) {
			model.put("errorMessage", "The login ,password or both are incorect");
			return "login";
		}
		
		model.put("name",name);
		model.put("pw",pw);
		return "welcome";
	}
}

