package com.bupt.flowpackage.common.domain;

import com.bupt.flowpackage.common.enums.ResultCode;
import com.bupt.flowpackage.common.exception.IException;

public class BaseResponse<T> extends BaseRequest implements IException{

	private static final long serialVersionUID = 1L;
	
	private Integer code;
	
	private String msg;
	
	private Integer subCode;
	
	private String subMessage;
	
	private T data;
	
	private Page<T> pages;
	
	public Page<T> getPages() {
		return pages;
	}

	public void setPages(Page<T> pages) {
		this.pages = pages;
	}
	
	public BaseResponse(){
		this(ResultCode.Result_SUCCESS);
	}
	
	public BaseResponse(T date){
		this.data = date;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setSubCode(Integer subCode) {
		this.subCode = subCode;
	}

	public void setSubMessage(String subMessage) {
		this.subMessage = subMessage;
	}

	public BaseResponse(Integer code,String message, Integer subCode, String subMessage){
		this.code = code;
		this.msg = message;
		this.subCode = subCode;
		this.subMessage = subMessage;
	}
	
	public BaseResponse(ResultCode result){
		this(result.getCode(), result.getMsg(), result.getCode(), result.getMsg());
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

	@Override
	public String getMsg() {
		return msg;
	}
}
