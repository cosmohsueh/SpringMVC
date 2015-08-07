package net.cosmo.spring;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 讀者檔
 * 
 * @author cosmo
 *
 */
public class Patron implements Serializable, Cloneable {

	private static final long serialVersionUID = 5722267922028310744L;

	private Long patronId;
	private String username;
	private Long institutionId;
	private String password;
	private String userName;
	private String email;
	private String mobilePhone;
	private String nationalIdNumber;
	private Date birthDate;
	private Date dateAdded;
	private String storeId;
	private String storeName;
	private Long packageQuantity;

	public Long getPatronId() {
		return patronId;
	}

	public void setPatronId(Long patronId) {
		this.patronId = patronId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(Long institutionId) {
		this.institutionId = institutionId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getNationalIdNumber() {
		return nationalIdNumber;
	}

	public void setNationalIdNumber(String nationalIdNumber) {
		this.nationalIdNumber = nationalIdNumber;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Long getPackageQuantity() {
		return packageQuantity;
	}

	public void setPackageQuantity(Long packageQuantity) {
		this.packageQuantity = packageQuantity;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
