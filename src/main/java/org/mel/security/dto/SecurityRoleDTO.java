package org.mel.security.dto;

import java.util.Date;
import java.util.Set;

public class SecurityRoleDTO {
	private Long id;
	private String name;
	private String description;
	private Date createTime;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	private Set<SecurityRightDTO> rights;

	public SecurityRoleDTO() {
	}

	public Set<SecurityRightDTO> getRights() {
		return rights;
	}

	public void setRights(Set<SecurityRightDTO> rights) {
		this.rights = rights;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "SecurityRoleDTO [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

}
