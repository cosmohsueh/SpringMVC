package com.FlySheet.SignUp.model;

public enum PICKUP {

	A('1', "火車站"), B('2', "高鐵站"), C('3', "自行前往");

	private char code;
	private String reason;

	PICKUP(char code, String reason) {
		this.code = code;
		this.reason = reason;
	}

	public char getCode() {
		return code;
	}

	public String getReason() {
		return reason;
	}

	public static PICKUP valueOf(char code) {
		for (PICKUP pickup : values()) {
			if (pickup.getCode() == code) {
				return pickup;
			}
		}
		return null;
	}
}
