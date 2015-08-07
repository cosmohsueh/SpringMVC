package net.cosmo.spring.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public ModelAndView goHome(){
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/viewXSLT")
	public ModelAndView viewXSLT(HttpServletRequest request, HttpServletResponse response){
		
		String xmlFile = "resources/citizens.xml";
		String contextPath = request.getSession().getServletContext().getRealPath("");
		String xmlFilePath = contextPath + File.separator + xmlFile;
		
		Source source = new StreamSource(new File(xmlFilePath));
		
		ModelAndView model = new ModelAndView("XSLTView");
		model.addObject("xmlSource", source);
		return model;
	}
}
