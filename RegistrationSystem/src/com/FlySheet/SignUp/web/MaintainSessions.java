package com.FlySheet.SignUp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin/Maintain")
public class MaintainSessions {

	@RequestMapping(value = "/Sessions")
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("admin/Maintain/ViewSessions");
		return model;
	}
	
	@RequestMapping(value = "/editSessions", method = RequestMethod.GET)
	public ModelAndView editSessions(){
		ModelAndView model = new ModelAndView("admin/Maintain/FormSessions");
		return model;
	}
	
	@RequestMapping(value = "/saveSessions", method = RequestMethod.POST)
	public ModelAndView saveSessions(){
		ModelAndView model = new ModelAndView("redirect:/admin/Maintain/Sessions");
		return model;
	}
}
