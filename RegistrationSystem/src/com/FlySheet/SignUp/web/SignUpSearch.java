package com.FlySheet.SignUp.web;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.FlySheet.SignUp.model.SignUpSearchModel;
import com.FlySheet.SignUp.service.ActivityService;
import com.FlySheet.SignUp.service.ApplicantsService;
import com.FlySheet.SignUp.service.SessionsService;

import data.Activity;
import data.Applicants;
import data.Sessions;

@Controller
@RequestMapping(value = "/admin")
public class SignUpSearch {
	
	@Autowired
	private ActivityService activityService;
	@Autowired
	private SessionsService sessionsService;
	@Autowired
	private ApplicantsService applicantsService;

	@RequestMapping(value = "/SignUpSearch", method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("admin/SignUpSearch");
		model.addObject("signUpSearchForm", new SignUpSearchModel());
		return model;
	}
	
	@RequestMapping(value = "/ActivityJson", method = RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody Set<Activity> getActivityJson(){
		return new HashSet<Activity>(activityService.findAll());
	}
	
	@RequestMapping(value = "/SessionsJson", method = RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody Set<Sessions> getSessionsJson(@RequestParam Integer activityId){
		return new HashSet<Sessions>(sessionsService.findSessionsByActivityId(activityId));
	}
	
	@RequestMapping(value = "/SignUpSearch", method = RequestMethod.POST)
	public ModelAndView search(@ModelAttribute(value = "signUpSearchForm") SignUpSearchModel signUpSearchForm){
		ModelAndView model = new ModelAndView();
		model.addObject("sessionsId", signUpSearchForm.getSessionsId());
		model.addObject("applicantsList", applicantsService.findApplicantsBySessionsId(signUpSearchForm.getSessionsId()));
		return model;
	}
	
	@RequestMapping(value = "/downloadExcel", method = RequestMethod.GET)
	public ModelAndView downloadExcel(@RequestParam Integer sessionsId){
		List<Applicants> applicantsList = applicantsService.findApplicantsBySessionsId(sessionsId);
        
        return new ModelAndView("excelView", "applicantsList", applicantsList);
	}
}
