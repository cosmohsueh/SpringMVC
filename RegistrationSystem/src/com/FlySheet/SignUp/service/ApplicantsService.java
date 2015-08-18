package com.FlySheet.SignUp.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.FlySheet.SignUp.dao.ApplicantsDAO;

import data.Applicants;

public class ApplicantsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicantsService.class);

	@Autowired
	private ApplicantsDAO applicantsDAO;
	
	public void saveApplicants(Applicants applicants){
		if(applicants.getApplicantsId() == null){
			applicantsDAO.save(applicants);
		}else{
			applicantsDAO.update(applicants);
		}
	}
	
	public Applicants findApplicantsById(Integer applicantsId){
		try {
			return applicantsDAO.findApplicantsById(applicantsId);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(),e );
		}
		return null;
	}
	
	public List<Applicants> findAll(){
		try {
			return applicantsDAO.findAll();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}
	
	public List<Applicants> findApplicantsBySessionsId(Integer sessionsId){
		try {
			return applicantsDAO.findApplicantsBySessionsId(sessionsId);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}
	
	public void delActivity(Integer applicantsId){
		applicantsDAO.delete(applicantsId);
	}

}
