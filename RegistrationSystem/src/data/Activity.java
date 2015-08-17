package data;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 報名活動主檔
 * 
 * @author cosmo
 *
 */
public class Activity implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	private Integer activityId;

	/**
	 * 活動名稱
	 */
	private String activityName;

	public Activity() {

	}

	public Activity(Integer activityId, String activityName) {
		super();
		this.activityId = activityId;
		this.activityName = activityName;
	}

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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
