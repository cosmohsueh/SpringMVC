package com.FlySheet.SignUp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class SignUpSearch {

	@RequestMapping(value = "/SignUpSearch", method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("admin/SignUpSearch");
		return model;
	}
	
}
