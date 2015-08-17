package com.FlySheet.SignUp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import data.Users;

public class UsersDAO {

	private JdbcTemplate jdbcTemplate;
	
	public UsersDAO(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Users findByUsername(String username) throws SQLException {
		String sql = "SELECT * FROM USERS WHERE USERNAME='" + username + "'";
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Users>() {
	 
	        @Override
	        public Users extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	Users users = new Users();
	            	users.setUsername(rs.getString("USERNAME"));
	            	users.setPassword(rs.getString("PASSWORD"));
	            	users.setUserName(rs.getString("USER_NAME"));
	            	users.setEmail(rs.getString("EMAIL"));
	                return users;
	            }
	 
	            return null;
	        }
	 
	    });
	}
	
	public List<Users> findAll() throws SQLException {
		List<Users> usersList = new ArrayList<Users>();
		String  sql = "select * from USERS";
		usersList = jdbcTemplate.query(sql, new RowMapper<Users>(){

			@Override
			public Users mapRow(ResultSet rs, int num) throws SQLException {
				Users users = new Users();
				users.setUsername(rs.getString("USERNAME"));
				users.setPassword(rs.getString("PASSWORD"));
				users.setUserName(rs.getString("USER_NAME"));
				users.setEmail(rs.getString("EMAIL"));
				return users;
			}
			
		});
		return usersList;
	}
	
	public void save(Users users) throws SQLException {
		String sql = "insert into USERS values(?, ?, ?, ?)";
		jdbcTemplate.update(sql, users.getUsername(), users.getPassword(), users.getUserName(), users.getEmail());
	}
	
	public void update(Users users) throws SQLException {
		String sql = "update USERS set PASSWORD=?, USER_NAME=?, EMAIL=? WHERE USERNAME=?";
		jdbcTemplate.update(sql, users.getPassword(), users.getUserName(), users.getEmail(), users.getUsername());
	}
	
	public void delete(String username) throws SQLException {
		String sql = "delete from USERS where USERNAME=?";
		jdbcTemplate.update(sql, username);
	}

}
