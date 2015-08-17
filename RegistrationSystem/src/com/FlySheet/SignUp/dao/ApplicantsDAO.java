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

	public Applicants findByApplicantsId(Long applicantsId) throws SQLException {
		String sql = "SELECT * FROM APPLICANTS WHERE APPLICANTS_ID=" + applicantsId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Applicants>() {

			@Override
			public Applicants extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Applicants applicants = new Applicants();
					applicants.setApplicantsId(rs.getInt("APPLICANTS_ID"));
					applicants.setActivityId(rs.getInt("ACTIVITY_ID"));
					applicants.setFullName(rs.getString("FULL_NAME"));
					applicants.setNationalIdNumber(rs.getString("NATIONAL_ID_NUMBER"));
					applicants.setOrganization(rs.getString("ORGANIZATION"));
					applicants.setPosition(rs.getString("POSITION"));
					applicants.setTel(rs.getString("TEL"));
					applicants.setCell(rs.getString("CELL"));
					applicants.setEmail(rs.getString("EMAIL"));
					applicants.setStay(rs.getInt("STAY"));
					applicants.setSessionsId(rs.getInt("SESSIONS_ID"));
					applicants.setPickUp(rs.getInt("PICK_UP"));
					applicants.setApplicantsDate(rs.getDate("APPLICANTS_DATE"));
					applicants.setGender(rs.getInt("GENDER"));
					applicants.setMeals(rs.getInt("MEALS"));
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
				applicants.setFullName(rs.getString("FULL_NAME"));
				applicants.setNationalIdNumber(rs.getString("NATIONAL_ID_NUMBER"));
				applicants.setOrganization(rs.getString("ORGANIZATION"));
				applicants.setPosition(rs.getString("POSITION"));
				applicants.setTel(rs.getString("TEL"));
				applicants.setCell(rs.getString("CELL"));
				applicants.setEmail(rs.getString("EMAIL"));
				applicants.setStay(rs.getInt("STAY"));
				applicants.setSessionsId(rs.getInt("SESSIONS_ID"));
				applicants.setPickUp(rs.getInt("PICK_UP"));
				applicants.setApplicantsDate(rs.getDate("APPLICANTS_DATE"));
				applicants.setGender(rs.getInt("GENDER"));
				applicants.setMeals(rs.getInt("MEALS"));
				return applicants;
			}

		});
		return activityList;
	}

	public void save(Applicants applicants) {
		String sql = "INSERT INTO APPLICANTS VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, applicants.getApplicantsId(),
				applicants.getActivityId(), applicants.getFullName(),
				applicants.getNationalIdNumber(), applicants.getOrganization(),
				applicants.getPosition(), applicants.getTel(),
				applicants.getCell(), applicants.getEmail(),
				applicants.getStay(), applicants.getSessionsId(),
				applicants.getPickUp(), applicants.getApplicantsDate(),
				applicants.getGender(), applicants.getMeals());
	}

	public void update(Applicants applicants) {
		String sql = "UPDATE APPLICANTS SET ACTIVITY_ID=?, FULL_NAME=?, NATIONAL_ID_NUMBER=?, ORGANIZATION=?, "
				+ "POSITION=?, TEL=?, CELL=?, EMAIL=?, STAY=?, SESSIONS_ID=?, PICK_UP=?, APPLICANTS_DATE=?, "
				+ "GENDER=?, MEALS=? WHERE APPLICANTS_ID=?";
		jdbcTemplate.update(sql, applicants.getActivityId(),
				applicants.getFullName(), applicants.getNationalIdNumber(),
				applicants.getOrganization(), applicants.getPosition(),
				applicants.getTel(), applicants.getCell(),
				applicants.getEmail(), applicants.getStay(),
				applicants.getSessionsId(), applicants.getPickUp(),
				applicants.getApplicantsDate(), applicants.getGender(),
				applicants.getMeals(), applicants.getApplicantsId());
	}

	public void delete(Applicants activity) {
		String sql = "DELETE FROM APPLICANTS WHERE APPLICANTS_ID=?";
		jdbcTemplate.update(sql, activity.getApplicantsId());
	}
}
