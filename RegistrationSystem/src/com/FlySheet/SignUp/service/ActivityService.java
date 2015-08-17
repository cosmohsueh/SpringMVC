package com.FlySheet.SignUp.service;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.FlySheet.SignUp.dao.ActivityDAO;

import data.Activity;

public class ActivityService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ActivityService.class);

	@Autowired
	private ActivityDAO activityDAO;
	
	public void saveActivity(Activity activity){
		if(activity.getActivityId() == null){
			activityDAO.save(activity);
		}else{
			activityDAO.update(activity);
		}
	}
	
	public Activity findActivityById(Integer activityId){
		try {
			return activityDAO.findByActivityId(activityId);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(),e );
		}
		return null;
	}
	
	public List<Activity> findAll(){
		try {
			return activityDAO.findAll();
		} catch (SQLException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return null;
	}
	
	public void delActivity(Integer activityId){
		activityDAO.delete(activityId);
	}

}
