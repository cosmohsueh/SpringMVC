package com.FlySheet.SignUp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class admin {

	@RequestMapping(value = "/admin.do")
	public String index(){
		return "redirect:/admin/SignUpSearch.do";
	}
}
