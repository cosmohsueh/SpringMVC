package com.FlySheet.SignUp.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.FlySheet.SignUp.service.ActivityService;
import com.FlySheet.SignUp.service.SessionsService;

import data.Activity;
import data.Sessions;

@Controller
@RequestMapping(value = "/admin/Maintain")
public class MaintainSessions {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MaintainSessions.class);
	
	@Autowired
	private SessionsService sessionsService;
	@Autowired
	private ActivityService activityService;

	@RequestMapping(value = "/Sessions")
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("admin/Maintain/ViewSessions");
		model.addObject("sessionsList", sessionsService.findAllWithActivity());
		return model;
	}
	
	@RequestMapping(value = "/editSessions", method = RequestMethod.GET)
	public ModelAndView editSessions(@RequestParam(required = false) Integer sessionsId){
		ModelAndView model = new ModelAndView("admin/Maintain/FormSessions");
		Sessions sessions = new Sessions();
		if(sessionsId != null){
			sessions = sessionsService.findSessionsById(sessionsId);
		}
		model.addObject("sessionsForm", sessions);
		List<Activity> activityList = activityService.findAll();
		model.addObject("activityList", activityList);
		return model;
	}
	
	@RequestMapping(value = "/saveSessions", method = RequestMethod.POST)
	public ModelAndView saveSessions(@ModelAttribute Sessions sessionsForm){
		LOGGER.debug(sessionsForm.toString());
		sessionsService.saveSessions(sessionsForm);
		return new ModelAndView("redirect:/admin/Maintain/Sessions");
	}
	
	@RequestMapping(value = "/delSessions", method = RequestMethod.GET)
	public ModelAndView delSessions(@RequestParam Integer sessionsId){
		LOGGER.debug("delSessions: " + sessionsId);
		sessionsService.delSessions(sessionsId);
		return new ModelAndView("redirect:/admin/Maintain/Sessions");
	}
	
}
