package com.FlySheet.SignUp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import data.Users;

public class UsersDAO {

	private JdbcTemplate jdbcTemplate;
	
	public UsersDAO(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Users findById(Long Id) throws SQLException {
		Users users = null;
			return users;
	}
	
	public List<Users> findAll() throws SQLException{
		List<Users> usersList = new ArrayList<Users>();
		return usersList;
	}
	
	public void save(Users users){
		
	}
	
	public void update(Users users){
		
	}
	
	public void delete(Users users){
		
	}

}
