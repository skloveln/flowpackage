package com.bupt.flowpackage.common.enums;

public enum ResultCode {
	
	Result_SUCCESS(200,"请求成功!"),
	Result_NO_SESSION(201,"会话超时,请重新登录!"),
	Result_NO_AUTH(202,"您无权限执行该操作!"),
	Result_WARN(400,"温馨提示!"),	
	Result_ERROR(500,"系统后台异常,请联系厂家!"),	
	Result_501(501,"请求参数错误!");
	
	private Integer code;
	private String msg;
	
	
	ResultCode(Integer code,String msg) {
		this.code=code;
		this.msg=msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
