package data;

import java.io.Serializable;
import java.util.Date;

public class Applicants implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	private Integer applicantsId;
	private Integer activityId;
	private String fullName;
	private String nationalIdNumber;

	/**
	 * 服務單位
	 */
	private String organization;

	/**
	 * 職稱
	 */
	private String position;

	/**
	 * 電話
	 */
	private String tel;

	/**
	 * 手機
	 */
	private String cell;

	private String email;

	/**
	 * 住宿 1:是 0:否
	 */
	private Integer stay;

	/**
	 * 場次
	 */
	private Integer sessionsId;

	/**
	 * 接送選項 1:火車站 2:高鐵站 3:自行前往
	 */
	private Integer pickUp;

	/**
	 * 報名日期
	 */
	private Date applicantsDate;

	/**
	 * 性別 1:男 2:女
	 */
	private Integer gender;

	/**
	 * 1:葷 2:素
	 */
	private Integer meals;

	public Applicants(Integer applicantsId, Integer activityId,
			String fullName, String nationalIdNumber, String organization,
			String position, String tel, String cell, String email,
			Integer stay, Integer sessionsId, Integer pickUp,
			Date applicantsDate, Integer gender, Integer meals) {
		this.applicantsId = applicantsId;
		this.activityId = activityId;
		this.fullName = fullName;
		this.nationalIdNumber = nationalIdNumber;
		this.organization = organization;
		this.position = position;
		this.tel = tel;
		this.cell = cell;
		this.email = email;
		this.stay = stay;
		this.sessionsId = sessionsId;
		this.pickUp = pickUp;
		this.applicantsDate = applicantsDate;
		this.gender = gender;
		this.meals = meals;
	}

	public Integer getApplicantsId() {
		return applicantsId;
	}

	public void setApplicantsId(Integer applicantsId) {
		this.applicantsId = applicantsId;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
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

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStay() {
		return stay;
	}

	public void setStay(Integer stay) {
		this.stay = stay;
	}

	public Integer getSessionsId() {
		return sessionsId;
	}

	public void setSessionsId(Integer sessionsId) {
		this.sessionsId = sessionsId;
	}

	public Integer getPickUp() {
		return pickUp;
	}

	public void setPickUp(Integer pickUp) {
		this.pickUp = pickUp;
	}

	public Date getApplicantsDate() {
		return applicantsDate;
	}

	public void setApplicantsDate(Date applicantsDate) {
		this.applicantsDate = applicantsDate;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getMeals() {
		return meals;
	}

	public void setMeals(Integer meals) {
		this.meals = meals;
	}

}
