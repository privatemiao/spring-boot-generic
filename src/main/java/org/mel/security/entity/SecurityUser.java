package org.mel.security.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.mel.framework.IDEntity;
import org.mel.framework.domain.UserStatus;

@Entity
public class SecurityUser extends IDEntity {
	private String loginId;
	private String password;
	@Enumerated(EnumType.STRING)
	private UserStatus userStatus;
	private Date lastLogin;

	// ========================================================================================
	@ManyToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	private Set<SecurityRole> roles = null;
	// ========================================================================================

	public Set<SecurityRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<SecurityRole> roles) {
		this.roles = roles;
	}

	public SecurityUser(String loginId, String password, UserStatus userStatus, Date lastLogin) {
		this.loginId = loginId;
		this.password = password;
		this.userStatus = userStatus;
		this.lastLogin = lastLogin;
	}

	public SecurityUser() {
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

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
