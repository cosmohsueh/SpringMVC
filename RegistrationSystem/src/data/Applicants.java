package data;

import java.io.Serializable;
import java.util.Date;

/**
 * 報名者資訊
 * 
 * @author cosmo
 *
 */
public class Applicants implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	private Integer applicantsId;
	
	/**
	 * 活動名稱
	 */
	private Integer activityId;
	
	/**
	 * 場次
	 */
	private Integer sessionsId;
	
	/**
	 * 錄取狀態
	 */
	private char confirm;

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
	private char stay;

	
	/**
	 * 接送選項 1:火車站 2:高鐵站 3:自行前往
	 */
	private char pickUp;
	
	/**
	 * 性別 1:男 2:女
	 */
	private char gender;

	/**
	 * 1:葷 2:素
	 */
	private char meals;

	/**
	 * 報名日期
	 */
	private Date applicantsDate;
	
	public Applicants(){
		
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

	public Integer getSessionsId() {
		return sessionsId;
	}

	public void setSessionsId(Integer sessionsId) {
		this.sessionsId = sessionsId;
	}

	public char getConfirm() {
		return confirm;
	}

	public void setConfirm(char confirm) {
		this.confirm = confirm;
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

	public char getStay() {
		return stay;
	}

	public void setStay(char stay) {
		this.stay = stay;
	}

	public char getPickUp() {
		return pickUp;
	}

	public void setPickUp(char pickUp) {
		this.pickUp = pickUp;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public char getMeals() {
		return meals;
	}

	public void setMeals(char meals) {
		this.meals = meals;
	}

	public Date getApplicantsDate() {
		return applicantsDate;
	}

	public void setApplicantsDate(Date applicantsDate) {
		this.applicantsDate = applicantsDate;
	}


}
