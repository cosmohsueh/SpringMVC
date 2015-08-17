package data;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 使用者
 * 
 * @author cosmo
 *
 */
public class Users implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	/**
	 * 帳號
	 */
	private String username;

	/**
	 * 密碼
	 */
	private String password;

	/**
	 * 使用者名稱
	 */
	private String userName;
	private String email;
	
	public Users(){
		
	}

	public Users(String username, String password, String userName, String email) {
		this.username = username;
		this.password = password;
		this.userName = userName;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
