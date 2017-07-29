package com.bupt.flowpackage.biz.error.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/error")
@Controller
public class ErrorController {
	private static final String ERROR_NO_AUTH = "errorpages/error-noauth";
	
	@RequestMapping("/noauth")
	public String noAuth() {
		return ERROR_NO_AUTH;
	}
}
