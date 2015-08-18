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

import com.FlySheet.SignUp.model.SessionsModel;

import data.Sessions;

public class SessionsDAO {

	private JdbcTemplate jdbcTemplate;

	public SessionsDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Sessions findById(Integer sessionsId) throws SQLException {
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
	
	public List<Sessions> findByActivityId(Integer activityId) throws SQLException {
		List<Sessions> noticeTemplateList = new ArrayList<Sessions>();
		String sql = "SELECT * FROM SESSIONS WHERE ACTIVITY_ID=" + activityId;
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
	
	public List<SessionsModel> findAllWithActivity() throws SQLException {
		List<SessionsModel> noticeTemplateList = new ArrayList<SessionsModel>();
		String sql = "SELECT * FROM SESSIONS s \n" +
				"left join activity a on s.ACTIVITY_ID = a.ACTIVITY_ID \n" +
				"order by SESSIONS_ID";
		noticeTemplateList = jdbcTemplate.query(sql, new RowMapper<SessionsModel>() {

			@Override
			public SessionsModel mapRow(ResultSet rs, int num) throws SQLException {
				SessionsModel sessionsModel = new SessionsModel();
				sessionsModel.setSessionsId(rs.getInt("SESSIONS_ID"));
				sessionsModel.setActivityId(rs.getInt("ACTIVITY_ID"));
				sessionsModel.setSessionsName(rs.getString("SESSIONS_NAME"));
				sessionsModel.setStartDate(rs.getDate("START_DATE"));
				sessionsModel.setEndDate(rs.getDate("END_DATE"));
				sessionsModel.setEnrollNotice(rs.getDate("ENROLL_NOTICE"));
				sessionsModel.setDueNotice(rs.getDate("DUE_NOTICE"));
				sessionsModel.setActivityName(rs.getString("ACTIVITY_NAME"));
				return sessionsModel;
			}

		});
		return noticeTemplateList;
	}

	public void save(Sessions sessions) {
		String sql = "INSERT INTO SESSIONS (ACTIVITY_ID, SESSIONS_NAME, START_DATE, END_DATE, ENROLL_NOTICE, DUE_NOTICE) " +
				"values(?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql,
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

	public void delete(Integer sessionsId) {
		String sql = "DELETE FROM SESSIONS WHERE SESSIONS_ID=?";
		jdbcTemplate.update(sql, sessionsId);
	}
}
