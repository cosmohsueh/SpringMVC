package com.FlySheet.SignUp.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.FlySheet.SignUp.service.ApplicantsService;

@Controller
@RequestMapping(value = "/admin")
public class SignUpVerify {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SignUpVerify.class);
	
	@Autowired
	private ApplicantsService applicantsService;

	@RequestMapping(value = "/SignUpVerify.do")
	public ModelAndView index(){
		return new ModelAndView("admin/SignUpVerify");
	}
	
	@RequestMapping(value = "/Verify.do")
	public ModelAndView verify(){
		return new ModelAndView("redirect:/admin/SignUpVerify.do");
	}
	
	@RequestMapping(value = "/Verify.do", method = RequestMethod.POST)
	public ModelAndView verify(HttpServletRequest request,
			@RequestParam("attachFile") CommonsMultipartFile attachFile){
		try {
			String filePath = request.getSession().getServletContext().getRealPath("/temp");
			File fileToCreate = new File(filePath, attachFile.getOriginalFilename());
			attachFile.transferTo(fileToCreate);
			applicantsService.VerifyApplicants(fileToCreate);
		} catch (IllegalStateException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (Exception e){
			LOGGER.error(e.getMessage(), e);
		}
		return new ModelAndView("redirect:/admin/SignUpSearch.do");
	}
}
