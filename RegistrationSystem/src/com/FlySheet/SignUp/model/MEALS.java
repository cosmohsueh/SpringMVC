package com.FlySheet.SignUp.model;

public enum MEALS {
	A("1", "葷"), B("2", "素");

	private String code;
	private String reason;

	MEALS(String code, String reason) {
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
		for (MEALS meals : values()) {
			if (meals.getCode().equals(code)) {
				return meals.getReason();
			}
		}
		return "";
	}
}
