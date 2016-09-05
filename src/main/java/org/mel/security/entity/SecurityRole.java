package org.mel.security.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.mel.framework.IDEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SecurityRole extends IDEntity {
	private String name;
	private String description;

	// =================================================================
	@ManyToMany(cascade = { CascadeType.REFRESH }, mappedBy = "roles")
	@JsonIgnore
	private Set<SecurityUser> users = null;

	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Set<SecurityRight> rights = null;
	// =================================================================

	public SecurityRole() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<SecurityUser> getUsers() {
		return users;
	}

	public void setUsers(Set<SecurityUser> users) {
		this.users = users;
	}

	public Set<SecurityRight> getRights() {
		return rights;
	}

	public void setRights(Set<SecurityRight> rights) {
		this.rights = rights;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}


}
