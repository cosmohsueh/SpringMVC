package com.cosmo.form.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import com.cosmo.form.model.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setFramework(convertDelimitedStringToList(rs.getString("framework")));
		user.setAddress(rs.getString("address"));
		user.setCountry(rs.getString("country"));
		user.setNewsletter(rs.getBoolean("newsletter"));
		user.setNumber(rs.getInt("number"));
		user.setPassword(rs.getString("password"));
		user.setSex(rs.getString("sex"));
		user.setSkill(convertDelimitedStringToList(rs.getString("skill")));
		return user;
	}

	private List<String> convertDelimitedStringToList(String delimitedString) {
		List<String> result = new ArrayList<String>();
		if (!StringUtils.isEmpty(delimitedString)) {
			result = Arrays.asList(StringUtils.delimitedListToStringArray(	delimitedString, ","));
		}

		return result;
	}
}
