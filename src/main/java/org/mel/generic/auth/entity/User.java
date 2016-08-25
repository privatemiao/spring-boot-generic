package org.mel.generic.auth.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.mel.framework.IDEntity;
import org.mel.security.entity.SecurityUser;

@Entity
public class User extends IDEntity {
	private String name;
	private String mobile;
	private String email;

	// ===============================================================
	@OneToOne(cascade = CascadeType.ALL)
	private SecurityUser securityUser;

	// ===============================================================

	public User() {
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

	public SecurityUser getSecurityUser() {
		return securityUser;
	}

	public void setSecurityUser(SecurityUser securityUser) {
		this.securityUser = securityUser;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
