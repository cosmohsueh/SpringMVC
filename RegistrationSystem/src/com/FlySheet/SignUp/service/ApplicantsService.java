package com.FlySheet.SignUp.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.FlySheet.SignUp.dao.ApplicantsDAO;
import com.FlySheet.SignUp.model.CONFIRM;

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
	
	public List<Applicants> findApplicantsBySessionsId(Integer sessionsId, boolean confirm){
		try {
			return applicantsDAO.findApplicantsBySessionsIdWithConfirm(sessionsId, confirm);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}
	
	public void delActivity(Integer applicantsId){
		applicantsDAO.delete(applicantsId);
	}
	
	public void VerifyApplicants(File attachFile) {
		try {
			HSSFWorkbook readWorkbook = new HSSFWorkbook(new FileInputStream(attachFile));
			HSSFSheet readSheet = readWorkbook.getSheetAt(0);
			int rNo = readSheet.getPhysicalNumberOfRows();
			for (int i = 1; i < rNo; i++) {
				HSSFRow r = readSheet.getRow(i);
				Integer applicantsId = ((Double)r.getCell(0).getNumericCellValue()).intValue();
				String confirm = r.getCell(3).toString();
				LOGGER.debug("ApplicantsId: " + applicantsId + ", confirm: " + confirm);
				updateApplicants(applicantsId, confirm);
			}
			readWorkbook.close();
		} catch (FileNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	public void updateApplicants(Integer applicantsId, String confirmChar){
		Applicants applicants = findApplicantsById(applicantsId);
		applicants.setConfirm(CONFIRM.getCodeByReason(confirmChar));
		saveApplicants(applicants);
	}

}
