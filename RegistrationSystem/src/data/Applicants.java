package data;

import java.io.Serializable;
import java.util.Date;

import com.FlySheet.SignUp.model.CONFIRM;
import com.FlySheet.SignUp.model.GENDER;
import com.FlySheet.SignUp.model.MEALS;
import com.FlySheet.SignUp.model.PICKUP;
import com.FlySheet.SignUp.model.STAY;

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
	private String confirm;

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
	private String stay;

	
	/**
	 * 接送選項 1:火車站 2:高鐵站 3:自行前往
	 */
	private String pickUp;
	
	/**
	 * 性別 1:男 2:女
	 */
	private String gender;

	/**
	 * 1:葷 2:素
	 */
	private String meals;

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

	public String getConfirm() {
		return confirm;
	}
	
	public String getConfirmEnum(){
		return CONFIRM.getReasonByCode(confirm);
	}

	public void setConfirm(String confirm) {
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

	public String getStay() {
		return stay;
	}
	
	public String getStayEnum(){
		return STAY.getReasonByCode(stay);
	}

	public void setStay(String stay) {
		this.stay = stay;
	}

	public String getPickUp() {
		return pickUp;
	}
	
	public String getPickUpEnum(){
		return PICKUP.getReasonByCode(pickUp);
	}

	public void setPickUp(String pickUp) {
		this.pickUp = pickUp;
	}

	public String getGender() {
		return gender;
	}
	
	public String getGenderEnum(){
		return GENDER.getReasonByCode(gender);
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMeals() {
		return meals;
	}
	
	public String getMealsEnum(){
		return MEALS.getReasonByCode(meals);
	}

	public void setMeals(String meals) {
		this.meals = meals;
	}

	public Date getApplicantsDate() {
		return applicantsDate;
	}

	public void setApplicantsDate(Date applicantsDate) {
		this.applicantsDate = applicantsDate;
	}


}
