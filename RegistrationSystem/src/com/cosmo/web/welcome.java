package com.cosmo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class welcome {

	@RequestMapping(value = "/")
	public ModelAndView goHome(){
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		model.addObject("name", "cosmo");
		return model;
	}
}
