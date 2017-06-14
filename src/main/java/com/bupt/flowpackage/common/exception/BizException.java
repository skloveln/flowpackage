package com.bupt.flowpackage.common.exception;

import com.bupt.flowpackage.common.enums.ResultCode;

public class BizException extends RuntimeException implements IException {
	private static final long serialVersionUID = 1L;

	private Integer code;
	
	private String message;
	
	private Integer subCode;
	
	private String subMessage;
	
	public BizException(ResultCode resultCode, Integer subCode, String subMessage) {
		super(subMessage);
		this.code = resultCode.getCode();
		this.message = resultCode.getMsg();
		this.subCode = subCode;
		this.subMessage = subMessage;
	}
	
	public BizException(Integer code, String message, Integer subCode, String subMessage) {
		super(subMessage);
		this.code = code;
		this.message = message;
		this.subCode = subCode;
		this.subMessage = subMessage;
	}
	
	public BizException(Integer code, String message, Integer subCode, String subMessage, Throwable cause) {
		super(subMessage, cause);
		this.code = code;
		this.message = message;
		this.subCode = subCode;
		this.subMessage = subMessage;
	}
	
	public static void warn(String subMessage) {
		throw new BizException(ResultCode.Result_WARN, ResultCode.Result_WARN.getCode(), subMessage);
	}

	public static void warn(Integer subCode, String subMessage) {
		throw new BizException(ResultCode.Result_WARN, subCode, subMessage);
	}

	@Override
	public Integer getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
	
	@Override
	public Integer getSubCode() {
		return subCode;
	}

	@Override
	public String getSubMessage() {
		return subMessage;
	}
}
