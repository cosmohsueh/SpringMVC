package com.FlySheet.SignUp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Login {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView goLogin(){
		return new ModelAndView("AdminLogin");
	}
}
