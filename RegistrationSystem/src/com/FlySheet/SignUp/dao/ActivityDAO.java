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

import data.Activity;

public class ActivityDAO {

	private JdbcTemplate jdbcTemplate;

	public ActivityDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Activity findByActivityId(Long activityId) throws SQLException {
		String sql = "SELECT * FROM ACTIVITY WHERE ACTIVITY_ID=" + activityId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Activity>() {

			@Override
			public Activity extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Activity activity = new Activity();
					activity.setActivityId(rs.getInt("ACTIVITY_ID"));
					activity.setActivityName(rs.getString("ACTIVITY_NAME"));
					return activity;
				}

				return null;
			}

		});
	}

	public List<Activity> findAll() throws SQLException {
		List<Activity> activityList = new ArrayList<Activity>();
		String sql = "select * from ACTIVITY";
		activityList = jdbcTemplate.query(sql, new RowMapper<Activity>() {

			@Override
			public Activity mapRow(ResultSet rs, int num) throws SQLException {
				Activity activity = new Activity();
				activity.setActivityId(rs.getInt("ACTIVITY_ID"));
				activity.setActivityName(rs.getString("ACTIVITY_NAME"));
				return activity;
			}

		});
		return activityList;
	}

	public void save(Activity activity) {
		String sql = "INSERT INTO ACTIVITY VALUES(?, ?)";
		jdbcTemplate.update(sql, activity.getActivityId(),
				activity.getActivityName());
	}

	public void update(Activity activity) {
		String sql = "UPDATE ACTIVITY SET ACTIVITY_NAME=? WHERE ACTIVITY_ID=?";
		jdbcTemplate.update(sql, activity.getActivityName(),
				activity.getActivityId());
	}

	public void delete(Activity activity) {
		String sql = "DELETE FROM ACTIVITY WHERE ACTIVITY_ID=?";
		jdbcTemplate.update(sql, activity.getActivityId());
	}
}
