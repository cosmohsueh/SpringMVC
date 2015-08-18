package com.FlySheet.SignUp.model;

public enum STAY {

	YES('1', "是"), NOT('0', "否");

	private char code;
	private String reason;

	STAY(char code, String reason) {
		this.code = code;
		this.reason = reason;
	}

	public char getCode() {
		return code;
	}

	public String getReason() {
		return reason;
	}

	public static STAY valueOf(char code) {
		for (STAY stay : values()) {
			if (stay.getCode() == code) {
				return stay;
			}
		}

		return null;
	}
}
