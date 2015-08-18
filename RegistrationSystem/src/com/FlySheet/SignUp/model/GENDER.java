package com.FlySheet.SignUp.model;

public enum GENDER {

	m('1', "男"), F('2', "女");

	private char code;
	private String reason;

	GENDER(char code, String reason) {
		this.code = code;
		this.reason = reason;
	}

	public char getCode() {
		return code;
	}

	public String getReason() {
		return reason;
	}

	public static GENDER valueOf(char code) {
		for (GENDER gender : values()) {
			if (gender.getCode() == code) {
				return gender;
			}
		}
		return null;
	}
}
