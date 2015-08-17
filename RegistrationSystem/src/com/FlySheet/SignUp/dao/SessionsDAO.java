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

import data.Sessions;

public class SessionsDAO {

	private JdbcTemplate jdbcTemplate;

	public SessionsDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Sessions findByUsername(Long sessionsId) throws SQLException {
		String sql = "SELECT * FROM SESSIONS WHERE SESSIONS_ID=" + sessionsId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Sessions>() {

			@Override
			public Sessions extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Sessions sessions = new Sessions();
					sessions.setSessionsId(rs.getInt("SESSIONS_ID"));
					sessions.setActivityId(rs.getInt("ACTIVITY_ID"));
					sessions.setSessionsName(rs.getString("SESSIONS_NAME"));
					sessions.setStartDate(rs.getDate("START_DATE"));
					sessions.setEndDate(rs.getDate("END_DATE"));
					sessions.setEnrollNotice(rs.getDate("ENROLL_NOTICE"));
					sessions.setDueNotice(rs.getDate("DUE_NOTICE"));
					return sessions;
				}

				return null;
			}

		});
	}

	public List<Sessions> findAll() throws SQLException {
		List<Sessions> noticeTemplateList = new ArrayList<Sessions>();
		String sql = "select * from SESSIONS";
		noticeTemplateList = jdbcTemplate.query(sql, new RowMapper<Sessions>() {

			@Override
			public Sessions mapRow(ResultSet rs, int num) throws SQLException {
				Sessions sessions = new Sessions();
				sessions.setSessionsId(rs.getInt("SESSIONS_ID"));
				sessions.setActivityId(rs.getInt("ACTIVITY_ID"));
				sessions.setSessionsName(rs.getString("SESSIONS_NAME"));
				sessions.setStartDate(rs.getDate("START_DATE"));
				sessions.setEndDate(rs.getDate("END_DATE"));
				sessions.setEnrollNotice(rs.getDate("ENROLL_NOTICE"));
				sessions.setDueNotice(rs.getDate("DUE_NOTICE"));
				return sessions;
			}

		});
		return noticeTemplateList;
	}

	public void save(Sessions sessions) {
		String sql = "INSERT INTO SESSIONS VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, sessions.getSessionsId(),
				sessions.getActivityId(), sessions.getSessionsName(),
				sessions.getStartDate(), sessions.getEndDate(),
				sessions.getEnrollNotice(), sessions.getDueNotice());
	}

	public void update(Sessions sessions) {
		String sql = "UPDATE SESSIONS SET ACTIVITY_ID=?, SESSIONS_NAME=?, START_DATE=?, END_DATE=?, "
				+ "ENROLL_NOTICE=?, DUE_NOTICE=? WHERE SESSIONS_ID=?";
		jdbcTemplate.update(sql, sessions.getActivityId(),
				sessions.getSessionsName(), sessions.getStartDate(),
				sessions.getEndDate(), sessions.getEnrollNotice(),
				sessions.getDueNotice(), sessions.getSessionsId());
	}

	public void delete(Sessions sessions) {
		String sql = "DELETE FROM SESSIONS WHERE SESSIONS_ID=?";
		jdbcTemplate.update(sql, sessions.getSessionsId());
	}
}
