package com.FlySheet.SignUp.model;

public enum CONFIRM {

	OK('1', "Y"), 
	NOT('0', "N");

	private char code;
	private String reason;

	CONFIRM(char code, String reason) {
		this.code = code;
		this.reason = reason;
	}

	public char getCode() {
		return code;
	}

	public String getReason() {
		return reason;
	}

	public static CONFIRM valueOf(char code) {
		for (CONFIRM confirm : values()) {
			if (confirm.getCode() == code) {
				return confirm;
			}
		}
		return null;
	}
}
