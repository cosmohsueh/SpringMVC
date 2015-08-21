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

import data.NoticeLog;

public class NoticeLogDAO {

	private JdbcTemplate jdbcTemplate;

	public NoticeLogDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public NoticeLog findNoticeLogById(Integer noticeLogId) throws SQLException {
		String sql = "SELECT * FROM NOTICE_LOG WHERE NOTICE_LOG_ID=" + noticeLogId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<NoticeLog>() {

			@Override
			public NoticeLog extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					NoticeLog noticeLog = new NoticeLog();
					noticeLog.setNoticeLogId(rs.getInt("NOTICE_LOG_ID"));
					noticeLog.setActivityId(rs.getInt("ACTIVITY_ID"));
					noticeLog.setSessionsId(rs.getInt("SESSIONS_ID"));
					noticeLog.setApplicantsId(rs.getInt("APPLICANTS_ID"));
					noticeLog.setNoticeType(rs.getInt("NOTICE_TYPE"));
					noticeLog.setFullName(rs.getString("FULL_NAME"));
					noticeLog.setNationalIdNumber(rs.getString("NATIONAL_ID_NUMBER"));
					noticeLog.setEmail(rs.getString("EMAIL"));
					noticeLog.setSubject(rs.getString("SUBJECT"));
					noticeLog.setContent(rs.getString("CONTENT"));
					noticeLog.setNoticeDate(rs.getDate("NOTICE_DATE"));
					return noticeLog;
				}

				return null;
			}

		});
	}
	
	public List<NoticeLog> findAll() throws SQLException {
		List<NoticeLog> noticeLogList = new ArrayList<NoticeLog>();
		String sql = "select * from NOTICE_LOG";
		noticeLogList = jdbcTemplate.query(sql, new RowMapper<NoticeLog>() {

			@Override
			public NoticeLog mapRow(ResultSet rs, int num) throws SQLException {
				NoticeLog noticeLog = new NoticeLog();
				noticeLog.setNoticeLogId(rs.getInt("NOTICE_LOG_ID"));
				noticeLog.setActivityId(rs.getInt("ACTIVITY_ID"));
				noticeLog.setSessionsId(rs.getInt("SESSIONS_ID"));
				noticeLog.setApplicantsId(rs.getInt("APPLICANTS_ID"));
				noticeLog.setNoticeType(rs.getInt("NOTICE_TYPE"));
				noticeLog.setFullName(rs.getString("FULL_NAME"));
				noticeLog.setNationalIdNumber(rs.getString("NATIONAL_ID_NUMBER"));
				noticeLog.setEmail(rs.getString("EMAIL"));
				noticeLog.setSubject(rs.getString("SUBJECT"));
				noticeLog.setContent(rs.getString("CONTENT"));
				noticeLog.setNoticeDate(rs.getDate("NOTICE_DATE"));
				return noticeLog;
			}

		});
		return noticeLogList;
	}
	
	public void save(NoticeLog noticeLog) {
		String sql = "INSERT INTO NOTICE_LOG (ACTIVITY_ID, SESSIONS_ID, APPLICANTS_ID, "
				+ "NOTICE_TYPE, FULL_NAME, NATIONAL_ID_NUMBER, EMAIL, SUBJECT, CONTENT, NOTICE_DATE) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, 
				noticeLog.getActivityId(), 
				noticeLog.getSessionsId(), 
				noticeLog.getApplicantsId(),
				noticeLog.getNoticeType(), 
				noticeLog.getFullName(), 
				noticeLog.getNationalIdNumber(),
				noticeLog.getEmail(), 
				noticeLog.getSubject(), 
				noticeLog.getContent(), 
				noticeLog.getNoticeDate());
	}

	public void update(NoticeLog noticeLog) {
		String sql = "UPDATE NOTICE_LOG SET ACTIVITY_ID=?, SESSIONS_ID=?, APPLICANTS_ID=?, NOTICE_TYPE=?, "
				+ "FULL_NAME=?, NATIONAL_ID_NUMBER=?, EMAIL=?, SUBJECT=?, CONTENT=?, NOTICE_DATE=? "
				+ "WHERE NOTICE_LOG_ID=?";
		jdbcTemplate.update(sql, 
				noticeLog.getActivityId(), 
				noticeLog.getSessionsId(), 
				noticeLog.getApplicantsId(),
				noticeLog.getNoticeType(), 
				noticeLog.getFullName(), 
				noticeLog.getNationalIdNumber(),
				noticeLog.getEmail(), 
				noticeLog.getSubject(), 
				noticeLog.getContent(), 
				noticeLog.getNoticeDate(),
				noticeLog.getNoticeLogId());
	}
}
