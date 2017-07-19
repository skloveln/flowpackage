package com.bupt.flowpackage.biz.auth.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bupt.flowpackage.biz.auth.model.AdminRoleListReq;
import com.bupt.flowpackage.biz.auth.service.AdminRoleService;
import com.bupt.flowpackage.common.domain.BaseResponse;
import com.bupt.flowpackage.common.exception.ExceptionHelper;
import com.bupt.flowpackage.mybatis.account.admin.model.AdminRole;
/**
* @Description: 管理员管理
* @author wangdaojian
* @company 摩尔科技有限公司版权所有
* @date 2017年6月23日 下午3:20:32
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	public static Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Resource
	private AdminRoleService adminRoleService;
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
	
	@RequestMapping("/admin-delete")
	public String adminDelete() {
		return "admin/admin-list";
	}   
	
	@ResponseBody
	@RequestMapping("/api/getAdminRoleList")
	public BaseResponse<AdminRole> getAdminRoleList(AdminRoleListReq req, HttpServletRequest request) {
		BaseResponse<AdminRole> baseResp = new BaseResponse<AdminRole>();
		try{
			baseResp = adminRoleService.getAdminListPage(req);
		}catch(Exception e) {
			baseResp = ExceptionHelper.createResponse(e, req);
		}finally{
			logger.info("\nreuqestNo={} login 返回对象resp=[{}]", req.getRequestNo(), baseResp);
		}
		return baseResp;
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
