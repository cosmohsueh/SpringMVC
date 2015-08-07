package com.cosmo.spring;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class SendEmailController {

	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value = "/sendmail.do", method = RequestMethod.POST)
	public String doSendEmail(
			final @RequestParam("recipient") String recipient, 
			final @RequestParam("subject") String subject,
			final @RequestParam("message") String message,
			final @RequestParam("attachFile") CommonsMultipartFile attachFile){
		System.out.println("To: " + recipient);
		System.out.println("subject: " + subject);
		System.out.println("message: " + message);
		System.out.println("attachFile:" + attachFile.getOriginalFilename());
		
//		SimpleMailMessage email = new SimpleMailMessage();
//		email.setTo(recipient);
//		email.setSubject(subject);
//		email.setText(message);
//		mailSender.send(email);

//		with attachFile
		mailSender.send(new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				messageHelper.setTo(recipient);
				messageHelper.setSubject(subject);
				messageHelper.setText(message);
				
				String attachName = attachFile.getOriginalFilename();
				if(!"".equals(attachName)){
					messageHelper.addAttachment(attachName, new InputStreamSource() {
						
						@Override
						public InputStream getInputStream() throws IOException {
							return attachFile.getInputStream();
						}
					});
				}
			}
		});
		
		return "Result";
	}
}
