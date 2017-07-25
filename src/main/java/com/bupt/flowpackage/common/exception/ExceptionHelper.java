package com.bupt.flowpackage.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bupt.flowpackage.common.domain.BaseRequest;
import com.bupt.flowpackage.common.domain.BaseResponse;
import com.bupt.flowpackage.common.enums.ResultCode;

public class ExceptionHelper {
	
	public static Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);
	
	public static <T> BaseResponse<T> createResponse(Throwable e, BaseRequest request){
		if (e instanceof IException) {
			IException ex = (IException) e;
			//logger.info("\n requestNo={} 请求业务失败! error={}, errMsg={}", request.getRequestNo(), ex.getSubCode(), ex.getSubMessage());
			return new BaseResponse<T>(ex.getCode(), ex.getMsg(), ex.getSubCode(), ex.getSubMessage());
		}else {
			logger.error("\n requestNo={} 请求系统异常!", request.getRequestNo(), e);
			return new BaseResponse<T>(ResultCode.Result_ERROR);
		}
	}
	
	public static <T> BaseResponse<T> createResponse(Throwable e){
		return createResponse(e);
	}
}
