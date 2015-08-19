package com.FlySheet.SignUp.model;

public enum CONFIRM {

	OK("Y", "1"), 
	NOT("N", "0");

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

	public static CONFIRM valueOfByCode(String code) {
		for (CONFIRM confirm : values()) {
			if (confirm.getCode().equalsIgnoreCase(code)) {
				return confirm;
			}
		}
		return null;
	}
}
