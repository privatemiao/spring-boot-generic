package org.mel.framework.request;

import org.springframework.data.domain.PageRequest;

public abstract class AbstractPageRequest extends AbstractSearchRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pageNumber = 0;
	private int pageSize = 10;

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public PageRequest getPageRequest() {
		return new PageRequest(pageNumber, pageSize);
	}

}
