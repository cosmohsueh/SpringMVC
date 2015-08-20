package com.FlySheet.SignUp.model;

public enum GENDER {

	m("1", "男"), F("2", "女");

	private String code;
	private String reason;

	GENDER(String code, String reason) {
		this.code = code;
		this.reason = reason;
	}

	public String getCode() {
		return code;
	}

	public String getReason() {
		return reason;
	}

	public static String getReasonByCode(String code) {
		for (GENDER gender : values()) {
			if (gender.getCode().equals(code)) {
				return gender.getReason();
			}
		}
		return "";
	}
}
