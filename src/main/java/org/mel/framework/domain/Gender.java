package org.mel.framework.domain;

public enum Gender {
	MALE, FEMALE;

	public String toChinese() {
		if (this == FEMALE) {
			return "女";
		} else {
			return "男";
		}
	}

}
