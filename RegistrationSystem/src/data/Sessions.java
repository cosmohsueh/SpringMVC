package data;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 場次
 * 
 * @author cosmo
 *
 */
public class Sessions implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	private Integer sessionsId;
	
	private Integer activityId;

	/**
	 * 場次名稱
	 */
	@NotEmpty
	private String sessionsName;

	/**
	 * 活動起日
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date startDate;

	/**
	 * 活動迄日
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date endDate;

	/**
	 * 錄取通知日期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date enrollNotice;

	/**
	 * 行前通知日期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	private Date dueNotice;
	
	public Sessions(){
		
	}

	public Sessions(Integer sessionsId, Integer activityId,
			String sessionsName, Date startDate, Date endDate,
			Date enrollNotice, Date dueNotice) {
		this.sessionsId = sessionsId;
		this.activityId = activityId;
		this.sessionsName = sessionsName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.enrollNotice = enrollNotice;
		this.dueNotice = dueNotice;
	}

	public Integer getSessionsId() {
		return sessionsId;
	}

	public void setSessionsId(Integer sessionsId) {
		this.sessionsId = sessionsId;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public String getSessionsName() {
		return sessionsName;
	}

	public void setSessionsName(String sessionsName) {
		this.sessionsName = sessionsName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
