package com.FlySheet.SignUp.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.FlySheet.SignUp.dao.UsersDAO;

import data.Users;

public class UsersService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(UsersService.class);

	@Autowired
	private UsersDAO usersDao;

	public void saveUsers(Users users) {
		try {
//			if (users.getUsername() != null && users.getUsername().isEmpty()) {
				usersDao.save(users);
//			} else {
//				usersDao.update(users);
//			}
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

	public Users findUsersByUsername(String username) {
		try {
			return usersDao.findByUsername(username);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}

	public void deleteUser(String username) {
		try {
			usersDao.delete(username);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
}
