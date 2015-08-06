package com.cosmo.form.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.cosmo.form.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public User findById(Integer id) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("id", id);

		String sql = "select * from USERS where id = :id";
		User result = null;
		try {
			result = namedParameterJdbcTemplate.queryForObject(sql, params, new UserMapper());
		} catch (EmptyResultDataAccessException e) {

		}

		return result;
	}

	@Override
	public List<User> findAll() {
		String sql = "select * from USERS";
		List<User> result = namedParameterJdbcTemplate.query(sql, new UserMapper());
		return result;
	}

	@Override
	public void save(User user) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "INSERT INTO USERS(NAME, EMAIL, ADDRESS, PASSWORD, NEWSLETTER, FRAMEWORK, SEX, NUMBER, COUNTRY, SKILL) "
				+ "VALUES ( :name, :email, :address, :password, :newsletter, :framework, :sex, :number, :country, :skill)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user), keyHolder);
		user.setId(keyHolder.getKey().intValue());
	}

	@Override
	public void update(User user) {
		String sql = "UPDATE USERS SET NAME=:name, EMAIL=:email, ADDRESS=:address, "
				+ "PASSWORD=:password, NEWSLETTER=:newsletter, FRAMEWORK=:framework, "
				+ "SEX=:sex, NUMBER=:number, COUNTRY=:country, SKILL=:skill WHERE id=:id";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM USERS WHERE id= :id";
		namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource("id",
				id));
	}

	private SqlParameterSource getSqlParameterByModel(User user) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", user.getId());
		paramSource.addValue("name", user.getName());
		paramSource.addValue("email", user.getEmail());
		paramSource.addValue("address", user.getAddress());
		paramSource.addValue("password", user.getPassword());
		paramSource.addValue("newsletter", user.isNewsletter());

		// join String
		paramSource.addValue("framework", convertListToDelimitedString(user.getFramework()));
		paramSource.addValue("sex", user.getSex());
		paramSource.addValue("number", user.getNumber());
		paramSource.addValue("country", user.getCountry());
		paramSource.addValue("skill", convertListToDelimitedString(user.getSkill()));
		return paramSource;
	}

	private String convertListToDelimitedString(List<String> list) {
		String result = "";
		if (list != null) {
			result = StringUtils.arrayToCommaDelimitedString(list.toArray());
		}
		return result;
	}

}
