package org.mel.framework.response;

import java.util.List;

public abstract class AbstractListResponse<T> extends AbstractResponse {

	private List<T> data;

	public AbstractListResponse() {
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
	
	
	
	
}
