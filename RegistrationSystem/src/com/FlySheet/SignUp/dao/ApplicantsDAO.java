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

import data.Applicants;

public class ApplicantsDAO {

	private JdbcTemplate jdbcTemplate;

	public ApplicantsDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Applicants findApplicantsById(Integer applicantsId) throws SQLException {
		String sql = "SELECT * FROM APPLICANTS WHERE APPLICANTS_ID=" + applicantsId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Applicants>() {

			@Override
			public Applicants extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Applicants applicants = new Applicants();
					applicants.setApplicantsId(rs.getInt("APPLICANTS_ID"));
					applicants.setActivityId(rs.getInt("ACTIVITY_ID"));
					applicants.setSessionsId(rs.getInt("SESSIONS_ID"));
					applicants.setConfirm(rs.getString("CONFIRM").charAt(0));
					applicants.setFullName(rs.getString("FULL_NAME"));
					applicants.setNationalIdNumber(rs.getString("NATIONAL_ID_NUMBER"));
					applicants.setOrganization(rs.getString("ORGANIZATION"));
					applicants.setPosition(rs.getString("POSITION"));
					applicants.setTel(rs.getString("TEL"));
					applicants.setCell(rs.getString("CELL"));
					applicants.setEmail(rs.getString("EMAIL"));
					applicants.setStay(rs.getString("STAY").charAt(0));
					applicants.setPickUp(rs.getString("PICK_UP").charAt(0));
					applicants.setGender(rs.getString("GENDER").charAt(0));
					applicants.setMeals(rs.getString("MEALS").charAt(0));
					applicants.setApplicantsDate(rs.getDate("APPLICANTS_DATE"));
					return applicants;
				}

				return null;
			}

		});
	}

	public List<Applicants> findAll() throws SQLException {
		List<Applicants> activityList = new ArrayList<Applicants>();
		String sql = "select * from APPLICANTS";
		activityList = jdbcTemplate.query(sql, new RowMapper<Applicants>() {

			@Override
			public Applicants mapRow(ResultSet rs, int num) throws SQLException {
				Applicants applicants = new Applicants();
				applicants.setApplicantsId(rs.getInt("APPLICANTS_ID"));
				applicants.setActivityId(rs.getInt("ACTIVITY_ID"));
				applicants.setSessionsId(rs.getInt("SESSIONS_ID"));
				if(rs.getString("CONFIRM") != null){
					applicants.setConfirm(rs.getString("CONFIRM").charAt(0));
				}
				applicants.setFullName(rs.getString("FULL_NAME"));
				applicants.setNationalIdNumber(rs.getString("NATIONAL_ID_NUMBER"));
				applicants.setOrganization(rs.getString("ORGANIZATION"));
				applicants.setPosition(rs.getString("POSITION"));
				applicants.setTel(rs.getString("TEL"));
				applicants.setCell(rs.getString("CELL"));
				applicants.setEmail(rs.getString("EMAIL"));
				applicants.setStay(rs.getString("STAY").charAt(0));
				applicants.setPickUp(rs.getString("PICK_UP").charAt(0));
				applicants.setGender(rs.getString("GENDER").charAt(0));
				applicants.setMeals(rs.getString("MEALS").charAt(0));
				applicants.setApplicantsDate(rs.getDate("APPLICANTS_DATE"));
				return applicants;
			}

		});
		return activityList;
	}
	
	public List<Applicants> findApplicantsBySessionsId(Integer sessionsId) throws SQLException {
		List<Applicants> activityList = new ArrayList<Applicants>();
		String sql = "SELECT * FROM APPLICANTS WHERE SESSIONS_ID=" + sessionsId;
		activityList = jdbcTemplate.query(sql, new RowMapper<Applicants>() {

			@Override
			public Applicants mapRow(ResultSet rs, int num) throws SQLException {
				Applicants applicants = new Applicants();
				applicants.setApplicantsId(rs.getInt("APPLICANTS_ID"));
				applicants.setActivityId(rs.getInt("ACTIVITY_ID"));
				applicants.setSessionsId(rs.getInt("SESSIONS_ID"));
				if(rs.getString("CONFIRM") != null){
					applicants.setConfirm(rs.getString("CONFIRM").charAt(0));
				}
				applicants.setFullName(rs.getString("FULL_NAME"));
				applicants.setNationalIdNumber(rs.getString("NATIONAL_ID_NUMBER"));
				applicants.setOrganization(rs.getString("ORGANIZATION"));
				applicants.setPosition(rs.getString("POSITION"));
				applicants.setTel(rs.getString("TEL"));
				applicants.setCell(rs.getString("CELL"));
				applicants.setEmail(rs.getString("EMAIL"));
				applicants.setStay(rs.getString("STAY").charAt(0));
				applicants.setPickUp(rs.getString("PICK_UP").charAt(0));
				applicants.setGender(rs.getString("GENDER").charAt(0));
				applicants.setMeals(rs.getString("MEALS").charAt(0));
				applicants.setApplicantsDate(rs.getDate("APPLICANTS_DATE"));
				return applicants;
			}

		});
		return activityList;
	}

	public void save(Applicants applicants) {
		String sql = "INSERT INTO APPLICANTS (ACTIVITY_ID, SESSIONS_ID, CONFIRM, FULL_NAME, "
				+ "NATIONAL_ID_NUMBER, ORGANIZATION, POSITION, TEL, CELL, EMAIL, STAY, PICK_UP, "
				+ "GENDER, MEALS, APPLICANTS_DATE) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, applicants.getActivityId(), applicants.getSessionsId(), applicants.getConfirm(),
				applicants.getFullName(), applicants.getNationalIdNumber(), applicants.getOrganization(),
				applicants.getPosition(), applicants.getTel(), applicants.getCell(), applicants.getEmail(),
				applicants.getStay(), applicants.getPickUp(), applicants.getGender(), applicants.getMeals(),
				applicants.getApplicantsDate());
	}

	public void update(Applicants applicants) {
		String sql = "UPDATE APPLICANTS SET ACTIVITY_ID=?, SESSIONS_ID=?, CONFIRM=?, FULL_NAME=?, "
				+ "NATIONAL_ID_NUMBER=?, ORGANIZATION=?, POSITION=?, TEL=?, CELL=?, EMAIL=?, STAY=?, "
				+ "PICK_UP=?, GENDER=?, MEALS=?, APPLICANTS_DATE=? WHERE APPLICANTS_ID=?";
		jdbcTemplate.update(sql, applicants.getActivityId(), applicants.getSessionsId(), applicants.getConfirm(),
				applicants.getFullName(), applicants.getNationalIdNumber(), applicants.getOrganization(),
				applicants.getPosition(), applicants.getTel(), applicants.getCell(), applicants.getEmail(),
				applicants.getStay(), applicants.getPickUp(), applicants.getGender(), applicants.getMeals(),
				applicants.getApplicantsDate(), applicants.getApplicantsId());
	}

	public void delete(Integer applicantsId) {
		String sql = "DELETE FROM APPLICANTS WHERE APPLICANTS_ID=?";
		jdbcTemplate.update(sql, applicantsId);
	}
}
