package com.bupt.flowpackage.biz.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AdminController {
	
	/**
	 * <p>管理员列表</p>   
	 * @param @param request
	 * @param @return      
	 * @return String
	 */
	@RequestMapping("/admin-list")
	public String adminList() {
		return "admin/admin-list";
	}
	
	/**
	 * <p>权限管理</p>   
	 * @param @param request
	 * @param @return      
	 * @return String
	 */
	@RequestMapping("/admin-permission")
	public String adminPermission() {
		return "admin/admin-permission";
	}
}
