package com.FlySheet.SignUp.web;

import java.sql.SQLException;

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

import com.FlySheet.SignUp.service.UsersService;

import data.Users;

@Controller
@RequestMapping(value = "/admin/Maintain")
public class MaintainUsers {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MaintainUsers.class);
	
	@Autowired
	private UsersService usersService;

	@RequestMapping(value = "/Users.do", method = RequestMethod.GET)
	public ModelAndView index() throws SQLException{
		ModelAndView model = new ModelAndView("admin/Maintain/ViewUsers");
		model.addObject("listUsers", usersService.findUsersAll());
		return model;
	}
	
	@RequestMapping(value = "/editUsers.do", method = RequestMethod.GET)
	public ModelAndView editUsers(@RequestParam(required = false) Integer userId){
		ModelAndView model = new ModelAndView("admin/Maintain/FormUsers");
		Users users = new Users();
		if(userId != null){
			users = usersService.findUsersById(userId);
		}
		model.addObject("usersForm", users);
		return model;
	}
	
	@RequestMapping(value = "/delUsers.do", method = RequestMethod.GET)
	public ModelAndView deleteUsers(@RequestParam Integer userId){
		LOGGER.debug("deleteUsers: " + userId);
		ModelAndView model = new ModelAndView("redirect:/admin/Maintain/Users.do");
		usersService.deleteUser(userId);
		return model;
	}
	
	@RequestMapping(value = "/saveUsers.do")
	public ModelAndView saveUsers(){
		return new ModelAndView("redirect:/admin/Maintain/Users.do");
	}
	
	@RequestMapping(value = "/saveUsers.do", method = RequestMethod.POST)
	public ModelAndView saveUsers(@ModelAttribute("usersForm") @Valid Users usersForm, BindingResult result){
		LOGGER.debug(usersForm.toString());
		ModelAndView model = new ModelAndView();
		if(result.hasErrors()){
			model.setViewName("admin/Maintain/FormUsers");
		}else{
			usersService.saveUsers(usersForm);
			model.setViewName("redirect:/admin/Maintain/Users.do");
		}
		return model;
	}
}
