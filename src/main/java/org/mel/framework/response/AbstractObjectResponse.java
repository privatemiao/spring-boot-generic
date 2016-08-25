package org.mel.framework.response;

public abstract class AbstractObjectResponse extends AbstractResponse {

	private Object object;

	public AbstractObjectResponse(boolean status, String message, Object object) {
		super(status, message);
		this.object = object;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}
