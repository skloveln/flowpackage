package com.bupt.flowpackage.common.exception;

public interface IException {
	
	Integer getCode();

	String getMessage();
	
	Integer getSubCode();
	
	String getSubMessage();
}
