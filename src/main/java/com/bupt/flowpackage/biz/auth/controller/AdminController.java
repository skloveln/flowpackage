package com.bupt.flowpackage.biz.auth.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bupt.flowpackage.biz.auth.model.AdminAddOrEditReq;
import com.bupt.flowpackage.biz.auth.model.AdminAddOrEditResp;
import com.bupt.flowpackage.biz.auth.model.AdminAddReq;
import com.bupt.flowpackage.biz.auth.model.AdminRoleListReq;
import com.bupt.flowpackage.biz.auth.model.AdminUpdateReq;
import com.bupt.flowpackage.biz.auth.service.AdminRoleService;
import com.bupt.flowpackage.common.domain.BaseResponse;
import com.bupt.flowpackage.common.domain.Page;
import com.bupt.flowpackage.common.exception.ExceptionHelper;
import com.bupt.flowpackage.mybatis.account.adminrole.model.AdminRole;
import com.bupt.flowpackage.mybatis.account.role.model.Role;
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
	
	@RequestMapping("/admin-add")
	public String adminAdd(ModelMap modelMap) {
		AdminAddOrEditResp resp = new AdminAddOrEditResp();
		try{
			List<Role> roleList = adminRoleService.getRoleList();
			resp.setRoleList(roleList);
			modelMap.addAttribute("resp", resp);
		}catch(Exception e) {
			logger.error("管理员添加页面访问失败!", e);
			throw e;
		}finally{
			logger.info("管理员添加页面返回resp={}", resp);
		}
		return "admin/admin-form";
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
			Page<AdminRole> pages = adminRoleService.getAdminListPage(req);
			baseResp.setPages(pages);
		}catch(Exception e) {
			baseResp = ExceptionHelper.createResponse(e, req);
		}finally{
			logger.info("\n获取管理员角色列表; reuqestNo={} 返回对象resp=[{}]", req.getRequestNo(), baseResp);
		}
		return baseResp;
	}
	
	/**
	 * <p>管理员添加修改</p>   
	 * @param @param req
	 * @param @return      
	 * @return BaseResponse<String>
	 */
	@ResponseBody
	@RequestMapping("/api/update")
	public BaseResponse<String> update(AdminAddOrEditReq req) {
		BaseResponse<String> baseResp = new BaseResponse<String>();
		try{
			if(req.getAdminId() != null && req.getAdminId() > 0) {
				AdminUpdateReq adminUpdateReq = new AdminUpdateReq();
				BeanUtils.copyProperties(req, adminUpdateReq);
				adminRoleService.adminUpdate(adminUpdateReq);
			}else {
				AdminAddReq adminAddReq = new AdminAddReq();
				BeanUtils.copyProperties(req, adminAddReq);
				adminRoleService.adminAdd(adminAddReq);
			}
		}catch(Exception e) {
			baseResp = ExceptionHelper.createResponse(e, req);
		}finally{
			logger.info("\n管理员新增或更新; reuqestNo={} 返回对象resp=[{}]", req.getRequestNo(), baseResp);
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
