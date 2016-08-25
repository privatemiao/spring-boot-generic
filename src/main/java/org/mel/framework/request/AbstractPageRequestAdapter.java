package org.mel.framework.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class AbstractPageRequestAdapter extends AbstractPageRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbstractPageRequestAdapter() {
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	

}
