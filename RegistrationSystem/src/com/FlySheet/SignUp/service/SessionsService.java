package com.FlySheet.SignUp.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.FlySheet.SignUp.dao.ActivityDAO;
import com.FlySheet.SignUp.dao.SessionsDAO;
import com.FlySheet.SignUp.model.SessionsModel;

import data.Sessions;

public class SessionsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SessionsService.class);

	@Autowired
	private SessionsDAO sessionsDAO;
	@Autowired
	private ActivityDAO activityDAO;
	
	public Sessions findSessionsById(Integer sessionsId){
		try {
			return sessionsDAO.findById(sessionsId);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}
	
	public List<Sessions> findAll(){
		try {
			return sessionsDAO.findAll();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}
	
	public List<SessionsModel> findAllWithActivity(){
		try{
			return sessionsDAO.findAllWithActivity();
		}catch(SQLException e){
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}
	
	public void saveSessions(Sessions sessions){
		if(sessions.getSessionsId() == null){
			sessionsDAO.save(sessions);
		}else{
			sessionsDAO.update(sessions);
		}
	}
	
	public void delSessions(Integer sessionsId){
		sessionsDAO.delete(sessionsId);
	}
	
}
