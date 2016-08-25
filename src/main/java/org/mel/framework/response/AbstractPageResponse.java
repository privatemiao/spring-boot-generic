package org.mel.framework.response;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class AbstractPageResponse<T> extends AbstractResponse {

	private List<T> data;

	private long totalElements;

	public AbstractPageResponse() {

	}

	public AbstractPageResponse(List<T> data, long totalElement) {
		this.data = data;
		this.totalElements = totalElement;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
