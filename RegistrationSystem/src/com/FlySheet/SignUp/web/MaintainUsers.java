package com.FlySheet.SignUp.web;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.FlySheet.SignUp.dao.UsersDAO;

@Controller
@RequestMapping(value = "/admin/Maintain")
public class MaintainUsers {
	
	@Autowired
	private UsersDAO usersDao;

	@RequestMapping(value = "/Users", method = RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("Maintain/Users");
		try {
			usersDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return model;
	}
}
