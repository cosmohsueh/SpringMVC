package com.cosmo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SendEmailController {

	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value = "/sendmail.do", method = RequestMethod.POST)
	public String doSendEmail(
			@RequestParam("recipient") String recipient, 
			@RequestParam("subject") String subject,
			@RequestParam("message") String message){
		System.out.println("To: " + recipient);
		System.out.println("subject: " + subject);
		System.out.println("message: " + message);
		
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipient);
		email.setSubject(subject);
		email.setText(message);
		
		mailSender.send(email);
		
		return "Result";
	}
}
