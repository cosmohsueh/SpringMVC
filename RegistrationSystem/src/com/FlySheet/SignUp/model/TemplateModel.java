package com.FlySheet.SignUp.model;

import java.util.Date;

public class TemplateModel {

	private Integer activityId;
	private String activityName;
	private Integer sessionsId;
	private String sessionsName;
	private Date enrollNotice;
	private Date dueNotice;
	private Integer noticeId;
	private Integer noticeType;
	private String subject;

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Integer getSessionsId() {
		return sessionsId;
	}

	public void setSessionsId(Integer sessionsId) {
		this.sessionsId = sessionsId;
	}

	public String getSessionsName() {
		return sessionsName;
	}

	public void setSessionsName(String sessionsName) {
		this.sessionsName = sessionsName;
	}

	public Date getEnrollNotice() {
		return enrollNotice;
	}

	public void setEnrollNotice(Date enrollNotice) {
		this.enrollNotice = enrollNotice;
	}

	public Date getDueNotice() {
		return dueNotice;
	}

	public void setDueNotice(Date dueNotice) {
		this.dueNotice = dueNotice;
	}

	public Integer getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public Integer getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(Integer noticeType) {
		this.noticeType = noticeType;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public boolean isResendEnroll(){
		return enrollNotice.before(new Date());
	}
	
	public boolean isResendDue(){
		return dueNotice.before(new Date());
	}

}
