package org.mel.security.dto;

import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.mel.framework.request.AbstractRequest;

public class SecurityRoleCreateRequest extends AbstractRequest {
	private String name;
	private String description;
	private Set<Long> rightIds;

	public SecurityRoleCreateRequest() {
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

	public Set<Long> getRightIds() {
		return rightIds;
	}

	public void setRightIds(Set<Long> rightIds) {
		this.rightIds = rightIds;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
