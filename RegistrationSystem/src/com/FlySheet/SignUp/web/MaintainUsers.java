package com.FlySheet.SignUp.web;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	@RequestMapping(value = "/Users", method = RequestMethod.GET)
	public ModelAndView index() throws SQLException{
		ModelAndView model = new ModelAndView("admin/Maintain/ViewUsers");
		model.addObject("listUsers", usersService.findUsersAll());
		return model;
	}
	
	@RequestMapping(value = "/editUsers", method = RequestMethod.GET)
	public ModelAndView editUsers(@RequestParam(required = false) String username){
		ModelAndView model = new ModelAndView("admin/Maintain/FormUsers");
		Users users = new Users();
		if(username != null && !username.isEmpty()){
			users = usersService.findUsersByUsername(username);
		}
		model.addObject("usersForm", users);
		return model;
	}
	
	@RequestMapping(value = "/delUsers", method = RequestMethod.GET)
	public ModelAndView deleteUsers(@RequestParam String username){
		LOGGER.debug("deleteUsers: " + username);
		ModelAndView model = new ModelAndView("redirect:/admin/Maintain/Users");
		usersService.deleteUser(username);
		return model;
	}
	
	@RequestMapping(value = "/saveUsers", method = RequestMethod.POST)
	public ModelAndView saveUsers(@ModelAttribute Users usersForm){
		LOGGER.debug(usersForm.toString());
		usersService.saveUsers(usersForm);
		ModelAndView model = new ModelAndView("redirect:/admin/Maintain/Users");
		return model;
	}
}
