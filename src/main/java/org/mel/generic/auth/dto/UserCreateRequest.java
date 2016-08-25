package org.mel.generic.auth.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.mel.framework.domain.UserStatus;
import org.mel.framework.request.AbstractRequest;

/**
 * 创建用户数据包
 * 
 * @author Mel
 *
 */
public class UserCreateRequest extends AbstractRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String loginId;

	private String password;

	private UserStatus userStatus;

	private String name;

	private String mobile;

	private String email;

	public UserCreateRequest() {
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserStatus getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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
