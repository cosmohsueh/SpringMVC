package com.FlySheet.SignUp.model;

public enum MEALS {
	A('1', "葷"), B('2', "素");

	private char code;
	private String reason;

	MEALS(char code, String reason) {
		this.code = code;
		this.reason = reason;
	}

	public char getCode() {
		return code;
	}

	public String getReason() {
		return reason;
	}

	public static MEALS valueOf(char code) {
		for (MEALS meals : values()) {
			if (meals.getCode() == code) {
				return meals;
			}
		}
		return null;
	}
}
