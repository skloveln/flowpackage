package com.bupt.flowpackage.common.domain;

import org.apache.commons.lang.StringUtils;

import com.bupt.flowpackage.common.enums.ResultCode;
import com.bupt.flowpackage.common.exception.IException;

public class BaseResponse<T> extends BaseRequest implements IException{

	private static final long serialVersionUID = 1L;
	
	private Integer code;
	
	private String msg;
	
	private Integer subCode;
	
	private String subMessage;
	
	private T data;
	
	public BaseResponse(){
		this(ResultCode.Result_SUCCESS, null);
	}
	
	public BaseResponse(T date, String requestNo){
		this();
		this.data = date;
		this.setRequestNo(requestNo);
	}
	
	public BaseResponse(Integer code,String message, Integer subCode, String subMessage, String requestNo){
		this.code = code;
		this.msg = message;
		this.subCode = subCode;
		this.subMessage = subMessage;
		if(StringUtils.isNotBlank(requestNo)) {
			this.setRequestNo(requestNo);
		}
	}
	
	public BaseResponse(ResultCode result, String requestNo){
		this(result.getCode(), result.getMsg(), result.getCode(), result.getMsg(), requestNo);
	}
	
	public static BaseResponse<String> success(BaseRequest req) {
		BaseResponse<String> baseResp = new BaseResponse<String>();
		baseResp.setRequestNo(req.getRequestNo());
		return baseResp;
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
