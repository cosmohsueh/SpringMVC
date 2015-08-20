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
