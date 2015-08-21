package data;

import java.io.Serializable;
import java.util.Date;

public class NoticeLog implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	private Integer noticeLogId;
	private Integer activityId;
	private Integer sessionsId;
	private Integer applicantsId;
	private Integer noticeType;
	private String fullName;
	private String nationalIdNumber;
	private String email;
	private String subject;
	private String content;
	private Date noticeDate;

	public Integer getNoticeLogId() {
		return noticeLogId;
	}

	public void setNoticeLogId(Integer noticeLogId) {
		this.noticeLogId = noticeLogId;
	}

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

	public Integer getApplicantsId() {
		return applicantsId;
	}

	public void setApplicantsId(Integer applicantsId) {
		this.applicantsId = applicantsId;
	}

	public Integer getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(Integer noticeType) {
		this.noticeType = noticeType;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNationalIdNumber() {
		return nationalIdNumber;
	}

	public void setNationalIdNumber(String nationalIdNumber) {
		this.nationalIdNumber = nationalIdNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

}
