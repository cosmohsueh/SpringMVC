package com.FlySheet.SignUp.model;

import data.Sessions;

public class SessionsModel extends Sessions{

	private static final long serialVersionUID = 1L;
	
	private String activityName;

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	
}
