package com.FlySheet.SignUp.model;

public enum STAY {

	YES("1", "是"), NOT("0", "否");

	private String code;
	private String reason;

	STAY(String code, String reason) {
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
		for (STAY stay : values()) {
			if (stay.getCode().equals(code)) {
				return stay.getReason();
			}
		}
		return "";
	}
}
