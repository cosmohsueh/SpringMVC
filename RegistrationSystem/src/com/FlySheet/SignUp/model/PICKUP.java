package com.FlySheet.SignUp.model;

public enum PICKUP {

	A("1", "火車站"), B("2", "高鐵站"), C("3", "自行前往");

	private String code;
	private String reason;

	PICKUP(String code, String reason) {
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
		for (PICKUP pickup : values()) {
			if (pickup.getCode().equals(code)) {
				return pickup.getReason();
			}
		}
		return "";
	}
}
