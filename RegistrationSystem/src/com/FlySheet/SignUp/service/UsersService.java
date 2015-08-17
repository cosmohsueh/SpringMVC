package com.FlySheet.SignUp.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.FlySheet.SignUp.dao.UsersDAO;

import data.Users;

public class UsersService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UsersService.class);

	@Autowired
	private UsersDAO usersDao;

	public void saveUsers(Users users) {
		try {
			if (users.getUserId() == null) {
				usersDao.save(users);
			} else {
				if(users.getPassword() == null || users.getPassword().isEmpty()){
					Users dbUsers = usersDao.findUsersById(users.getUserId());
					users.setPassword(dbUsers.getPassword());
				}
				usersDao.update(users);
			}
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}

	public List<Users> findUsersAll() {
		try {
			return usersDao.findAll();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	public Users findUsersById(Integer userId) {
		try {
			return usersDao.findUsersById(userId);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	public void deleteUser(Integer userId) {
		try {
			usersDao.delete(userId);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
}
