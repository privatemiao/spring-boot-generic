package org.mel.security.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class SecurityRoleUpdateRequest extends SecurityRoleCreateRequest {
	private Long id;

	public SecurityRoleUpdateRequest() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
