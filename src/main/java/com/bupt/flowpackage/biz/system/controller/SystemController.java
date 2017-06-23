package com.bupt.flowpackage.biz.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class SystemController {
	
	/**
	 * <p>系统日志</p>   
	 * @param @param request
	 * @param @return      
	 * @return String
	 */
	@RequestMapping("/system-log")
	public String adminPermission() {
		return "system/system-log";
	}
}
