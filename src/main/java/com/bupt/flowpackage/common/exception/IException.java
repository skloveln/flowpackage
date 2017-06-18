package com.bupt.flowpackage.common.exception;

public interface IException {
	
	Integer getCode();

	String getMsg();
	
	Integer getSubCode();
	
	String getSubMessage();
}
