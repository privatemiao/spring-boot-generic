package org.mel.framework.response;

import org.apache.commons.lang3.builder.ToStringBuilder;

public abstract class AbstractResponse {
	private boolean success;
	private String message;

	public AbstractResponse() {
	}

	public AbstractResponse(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public static AbstractResponse createResponse(final boolean status) {
		return new AbstractResponse() {
			@Override
			public boolean isSuccess() {
				return status;
			}
		};
	}

	public static AbstractResponse createResponse(final boolean status, final String message) {
		return new AbstractResponse() {

			@Override
			public boolean isSuccess() {
				return status;
			}

			@Override
			public String getMessage() {
				return message;
			}

		};
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
