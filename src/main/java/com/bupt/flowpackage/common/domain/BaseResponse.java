package com.bupt.flowpackage.common.domain;

import com.bupt.flowpackage.common.enums.ResultCode;
import com.bupt.flowpackage.common.exception.IException;

public class BaseResponse<T> extends BaseRequest implements IException{

	private static final long serialVersionUID = 1L;
	
	private Integer code;
	
	private String message;
	
	private Integer subCode;
	
	private String subMessage;
	
	private T data;
	
	public BaseResponse(Integer code,String message, Integer subCode, String subMessage){
		this.code = code;
		this.message = message;
		this.subCode = subCode;
		this.subMessage = subMessage;
	}
	
	public BaseResponse(ResultCode result){
		this.code = result.getCode();
		this.message = result.getMsg();
		this.subCode = result.getCode();
		this.subMessage = result.getMsg();
	}
	
	public BaseResponse(T data){
		this.code = ResultCode.Result_SUCCESS.getCode();
		this.message = ResultCode.Result_SUCCESS.getMsg();
		this.subCode = ResultCode.Result_SUCCESS.getCode();
		this.subMessage = ResultCode.Result_SUCCESS.getMsg();;
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public Integer getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public Integer getSubCode() {
		return subCode;
	}

	@Override
	public String getSubMessage() {
		return subMessage;
	}
	
	public boolean isSuccess(){
		return code.equals(ResultCode.Result_SUCCESS.getCode());
	}
}
