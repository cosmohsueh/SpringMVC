package com.FlySheet.SignUp.model;

public enum CONFIRM {

	OK("1", "Y"), 
	NOT("0", "N");

	private String code;
	private String reason;

	CONFIRM(String code, String reason) {
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
		for (CONFIRM confirm : values()) {
			if (confirm.getCode().equalsIgnoreCase(code)) {
				return confirm.getReason();
			}
		}
		return "";
	}
	
	public static String getCodeByReason(String reason) {
		for (CONFIRM confirm : values()) {
			if (confirm.getReason().equalsIgnoreCase(reason)) {
				return confirm.getCode();
			}
		}
		return "";
	}
}
