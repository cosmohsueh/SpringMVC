package com.cosmo.form.service;

import java.util.List;

import com.cosmo.form.model.User;

public interface UserService {
	
	User findById(Integer id);
	
	List<User> findAll();
	
	void saveOrUpdate(User user);
	
	void delete(Integer id);
}
