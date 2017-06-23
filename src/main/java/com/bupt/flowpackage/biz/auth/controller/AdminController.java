package com.bupt.flowpackage.biz.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
* @Description: 管理员管理
* @author wangdaojian
* @company 摩尔科技有限公司版权所有
* @date 2017年6月23日 下午3:20:32
 */
@Controller
@RequestMapping("/admin")
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
