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

import com.FlySheet.SignUp.model.TemplateModel;

import data.NoticeTemplate;

public class NoticeTemplateDAO {

	private JdbcTemplate jdbcTemplate;

	public NoticeTemplateDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public NoticeTemplate findByNoticeId(Integer noticeId) throws SQLException {
		String sql = "SELECT * FROM NOTICE_TEMPLATE WHERE NOTICE_ID=" + noticeId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<NoticeTemplate>() {

			@Override
			public NoticeTemplate extractData(ResultSet rs)
					throws SQLException, DataAccessException {
				if (rs.next()) {
					NoticeTemplate noticeTemplate = new NoticeTemplate();
					noticeTemplate.setNoticeId(rs.getInt("NOTICE_ID"));
					noticeTemplate.setSessionId(rs.getInt("SESSION_ID"));
					noticeTemplate.setNoticeType(rs.getInt("NOTICE_TYPE"));
					noticeTemplate.setSubject(rs.getString("SUBJECT"));
					noticeTemplate.setContent(rs.getString("CONTENT"));
					return noticeTemplate;
				}

				return null;
			}

		});
	}
	
	public NoticeTemplate findBySessionIdAndNoticeType(Integer sessionId, Integer noticeType) throws SQLException {
		String sql = "SELECT * FROM NOTICE_TEMPLATE WHERE SESSION_ID=" + sessionId + 
				" AND NOTICE_TYPE=" + noticeType;
		return jdbcTemplate.query(sql, new ResultSetExtractor<NoticeTemplate>() {

			@Override
			public NoticeTemplate extractData(ResultSet rs)
					throws SQLException, DataAccessException {
				if (rs.next()) {
					NoticeTemplate noticeTemplate = new NoticeTemplate();
					noticeTemplate.setNoticeId(rs.getInt("NOTICE_ID"));
					noticeTemplate.setSessionId(rs.getInt("SESSION_ID"));
					noticeTemplate.setNoticeType(rs.getInt("NOTICE_TYPE"));
					noticeTemplate.setSubject(rs.getString("SUBJECT"));
					noticeTemplate.setContent(rs.getString("CONTENT"));
					return noticeTemplate;
				}

				return null;
			}

		});
	}

	public List<NoticeTemplate> findAll() throws SQLException {
		List<NoticeTemplate> noticeTemplateList = new ArrayList<NoticeTemplate>();
		String sql = "select * from NOTICE_TEMPLATE";
		noticeTemplateList = jdbcTemplate.query(sql, new RowMapper<NoticeTemplate>() {

			@Override
			public NoticeTemplate mapRow(ResultSet rs, int num)
					throws SQLException {
				NoticeTemplate noticeTemplate = new NoticeTemplate();
				noticeTemplate.setNoticeId(rs.getInt("NOTICE_ID"));
				noticeTemplate.setSessionId(rs.getInt("SESSION_ID"));
				noticeTemplate.setNoticeType(rs.getInt("NOTICE_TYPE"));
				noticeTemplate.setSubject(rs.getString("SUBJECT"));
				noticeTemplate.setContent(rs.getString("CONTENT"));
				return noticeTemplate;
			}

		});
		return noticeTemplateList;
	}
	
	public List<TemplateModel> findTemplateModelView() throws SQLException {
		List<TemplateModel> templateModelList = new ArrayList<TemplateModel>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT a.ACTIVITY_ID, a.ACTIVITY_NAME, s.SESSIONS_ID, s.SESSIONS_NAME, s.ENROLL_NOTICE, s.DUE_NOTICE, n.NOTICE_ID, n.NOTICE_TYPE, n.SUBJECT \n")
			.append("FROM activity a \n")
			.append("LEFT JOIN sessions s ON a.ACTIVITY_ID = s.ACTIVITY_ID \n")
			.append("LEFT JOIN notice_template n ON s.SESSIONS_ID = n.SESSION_ID \n")
			.append("WHERE n.NOTICE_ID IS NOT NULL");
		
		templateModelList = jdbcTemplate.query(sql.toString(), new RowMapper<TemplateModel>(){

			@Override
			public TemplateModel mapRow(ResultSet rs, int num)
					throws SQLException {
				TemplateModel templateModel = new TemplateModel();
				templateModel.setActivityId(rs.getInt("ACTIVITY_ID"));
				templateModel.setActivityName(rs.getString("ACTIVITY_NAME"));
				templateModel.setSessionsId(rs.getInt("SESSIONS_ID"));
				templateModel.setSessionsName(rs.getString("SESSIONS_NAME"));
				templateModel.setEnrollNotice(rs.getDate("ENROLL_NOTICE"));
				templateModel.setDueNotice(rs.getDate("DUE_NOTICE"));
				templateModel.setNoticeId(rs.getInt("NOTICE_ID"));
				templateModel.setNoticeType(rs.getInt("NOTICE_TYPE"));
				templateModel.setSubject(rs.getString("SUBJECT"));
				return templateModel;
			}
			
		});
		return templateModelList;
	}
	
	public void save(NoticeTemplate noticeTemplate) {
		String sql = "INSERT INTO NOTICE_TEMPLATE VALUES(?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, noticeTemplate.getNoticeId(),
				noticeTemplate.getSessionId(), noticeTemplate.getNoticeType(),
				noticeTemplate.getSubject(), noticeTemplate.getContent());
	}

	public void update(NoticeTemplate noticeTemplate) {
		String sql = "UPDATE NOTICE_TEMPLATE SET SESSION_ID=?, NOTICE_TYPE=?, SUBJECT=?, CONTENT=? WHERE NOTICE_ID=?";
		jdbcTemplate.update(sql, noticeTemplate.getSessionId(),
				noticeTemplate.getNoticeType(), noticeTemplate.getSubject(),
				noticeTemplate.getContent(), noticeTemplate.getNoticeId());
	}

	public void delete(NoticeTemplate noticeTemplate) {
		String sql = "DELETE FROM NOTICE_TEMPLATE WHERE NOTICE_ID=?";
		jdbcTemplate.update(sql, noticeTemplate.getNoticeId());
	}
}
