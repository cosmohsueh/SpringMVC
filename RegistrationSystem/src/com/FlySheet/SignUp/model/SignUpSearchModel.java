package com.FlySheet.SignUp.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class SignUpSearchModel {

	private Integer activityId;
	private Integer sessionsId;

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public Integer getSessionsId() {
		return sessionsId;
	}

	public void setSessionsId(Integer sessionsId) {
		this.sessionsId = sessionsId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
