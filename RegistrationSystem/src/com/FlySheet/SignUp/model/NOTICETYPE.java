package com.FlySheet.SignUp.model;

public enum NOTICETYPE {

	A(1, "報到通知"), B(2, "錄取通知"), C(3, "未錄取通知"), D(4, "行前通知");

	private Integer code;
	private String reason;

	NOTICETYPE(Integer code, String reason) {
		this.code = code;
		this.reason = reason;
	}

	public Integer getCode() {
		return code;
	}

	public String getReason() {
		return reason;
	}

}
