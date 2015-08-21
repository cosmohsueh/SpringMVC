package com.FlySheet.SignUp.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.FlySheet.SignUp.service.ActivityService;

import data.Activity;

@Controller
@RequestMapping(value = "/admin/Maintain")
public class MaintainActivity {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MaintainActivity.class);
	
	@Autowired
	private ActivityService activityService;

	@RequestMapping(value = "/Activity", method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("admin/Maintain/ViewActivity");
		model.addObject("activityList", activityService.findAll());
		return model;
	}
	
	@RequestMapping(value = "/editActivity", method = RequestMethod.GET)
	public ModelAndView editActivity(@RequestParam(required = false) Integer activityId){
		ModelAndView model = new ModelAndView("admin/Maintain/FormActivity");
		Activity activity = new Activity();
		if(activityId != null){
			activity = activityService.findActivityById(activityId);
		}
		model.addObject("activityForm", activity);
		return model;
	}
	
	@RequestMapping(value = "/delActivity", method = RequestMethod.GET)
	public ModelAndView delActivity(@RequestParam Integer activityId){
		LOGGER.debug("delActivity: " + activityId);
		activityService.delActivity(activityId);
		return new ModelAndView("redirect:/admin/Maintain/Activity");
	}
	
	@RequestMapping(value = "/saveActivity", method = RequestMethod.POST)
	public ModelAndView saveActivity(@ModelAttribute("activityForm") @Valid Activity activityForm, BindingResult result){
		LOGGER.debug(activityForm.toString());
		ModelAndView model = new ModelAndView();
		if(result.hasErrors()){
			model.setViewName("admin/Maintain/FormActivity");
		}else{
			activityService.saveActivity(activityForm);
			model.setViewName("redirect:/admin/Maintain/Activity");
		}
		return model;
	}
}
