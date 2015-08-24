package com.FlySheet.SignUp.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.FlySheet.SignUp.model.NOTICETYPE;
import com.FlySheet.SignUp.service.NoticeService;
import com.FlySheet.SignUp.service.SessionsService;

import data.NoticeTemplate;

@Controller
@RequestMapping(value = "/admin/Maintain")
public class MaintainNoticeTemplate {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MaintainNoticeTemplate.class);
	
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private SessionsService sessionsService;

	@RequestMapping(value = "/NoticeTemplate.do")
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("admin/Maintain/ViewNoticeTemplate");
		model.addObject("templateModelList", noticeService.findTemplateModelView());
		model.addObject("noticeTypeList", NOTICETYPE.values());
		return model;
	}
	
	@RequestMapping(value = "/editTemplate.do", method = RequestMethod.GET)
	public ModelAndView editTemplate(@RequestParam(required = false) Integer noticeId){
		ModelAndView model = new ModelAndView("admin/Maintain/FormNoticeTemplate");
		NoticeTemplate template = new NoticeTemplate();
		if(noticeId != null){
			template = noticeService.findTemplateById(noticeId);
		}
		model.addObject("templateForm", template);
		model.addObject("sessionsList", sessionsService.findAll());
		model.addObject("noticeTypeList", NOTICETYPE.values());
		return model;
	}
	
	@RequestMapping(value = "/resendNotice.do", method = RequestMethod.GET)
	public ModelAndView resendNotice(@RequestParam Integer noticeId){
		NoticeTemplate noticeTemp = noticeService.findTemplateById(noticeId);
		if(noticeTemp != null){
			noticeService.resendNotice(noticeTemp);
		}
		return new ModelAndView("redirect:/admin/Maintain/NoticeTemplate.do");
	}
	
	@RequestMapping(value = "/saveTemplate.do", method = RequestMethod.GET)
	public ModelAndView saveTemplate(){
		return new ModelAndView("redirect:/admin/Maintain/NoticeTemplate.do");
	}
	
	@RequestMapping(value = "/saveTemplate.do", method = RequestMethod.POST)
	public ModelAndView saveTemplate(@ModelAttribute NoticeTemplate templateForm){
		LOGGER.debug(templateForm.toString());
		noticeService.saveTemplate(templateForm);
		return new ModelAndView("redirect:/admin/Maintain/NoticeTemplate.do");
	}
	
}