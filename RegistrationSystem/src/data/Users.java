package data;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 使用者
 * 
 * @author cosmo
 *
 */
public class Users implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	private Integer userId;

	/**
	 * 帳號
	 */
	@NotEmpty
	private String username;

	/**
	 * 密碼
	 */
	@NotEmpty
	private String password;

	/**
	 * 使用者名稱
	 */
	@NotEmpty
	private String userName;
	
	@Email
	@NotEmpty
	private String email;

	public Users() {

	}

	public Users(Integer userId, String username, String password,
			String userName2, String email) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		userName = userName2;
		this.email = email;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
