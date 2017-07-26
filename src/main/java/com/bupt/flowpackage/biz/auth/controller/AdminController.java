package com.bupt.flowpackage.biz.auth.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bupt.flowpackage.biz.auth.model.AdminAddOrEditReq;
import com.bupt.flowpackage.biz.auth.model.AdminAddOrEditResp;
import com.bupt.flowpackage.biz.auth.model.AdminAddReq;
import com.bupt.flowpackage.biz.auth.model.AdminRoleListReq;
import com.bupt.flowpackage.biz.auth.model.AdminUpdateReq;
import com.bupt.flowpackage.biz.auth.service.AdminRoleService;
import com.bupt.flowpackage.common.domain.BaseResponse;
import com.bupt.flowpackage.common.domain.Page;
import com.bupt.flowpackage.common.domain.SessionVo;
import com.bupt.flowpackage.common.exception.BizException;
import com.bupt.flowpackage.common.exception.ExceptionHelper;
import com.bupt.flowpackage.common.session.SessionUtil;
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
		}
		return "admin/admin-form";
	} 
	
	@RequestMapping("/admin-edit")
	public String adminEdit(@RequestParam(required=true)Integer id, ModelMap modelMap) {
		AdminAddOrEditResp resp = new AdminAddOrEditResp();
		try{
			List<Role> roleList = adminRoleService.getRoleList();
			resp.setRoleList(roleList);
			AdminRole adminRole = adminRoleService.getAdminRoleByKey(id);
			if(adminRole != null) {
				resp.setAdmin(adminRole);
			}
			modelMap.addAttribute("resp", resp);
		}catch(Exception e) {
			logger.error("管理员添加页面访问失败!", e);
			throw e;
		}
		return "admin/admin-form";
	} 
	
	@ResponseBody
	@RequestMapping("/admin-delete")
	public BaseResponse<String> adminDelete(@RequestParam(required=true)Integer id) {
		BaseResponse<String> baseResp = new BaseResponse<String>();
		try{
			adminRoleService.adminDelete(id);
			baseResp.setMsg("管理员删除成功");
		}catch(Exception e) {
			baseResp = ExceptionHelper.createResponse(e);
		}
		return baseResp;
	}   
	
	@ResponseBody
	@RequestMapping("/api/getAdminRoleList")
	public BaseResponse<AdminRole> getAdminRoleList(AdminRoleListReq req) {
		BaseResponse<AdminRole> baseResp = new BaseResponse<AdminRole>();
		try{
			Page<AdminRole> pages = adminRoleService.getAdminListPage(req);
			baseResp.setPages(pages);
		}catch(Exception e) {
			baseResp = ExceptionHelper.createResponse(e, req);
		}
		return baseResp;
	}
	
	@ResponseBody
	@RequestMapping("/api/checkSession")
	public BaseResponse<String> checkSession() {
		BaseResponse<String> baseResp = new BaseResponse<String>();
		try{
			SessionVo sessionVo = SessionUtil.getAdminSessionInfo();
			if(sessionVo == null) {
				BizException.warn(101, "会话超时，请重新登陆!");
			}
		}catch(Exception e) {
			baseResp = ExceptionHelper.createResponse(e);
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
				baseResp.setMsg("管理员修改成功");
			}else {
				AdminAddReq adminAddReq = new AdminAddReq();
				BeanUtils.copyProperties(req, adminAddReq);
				adminRoleService.adminAdd(adminAddReq);
				baseResp.setMsg("管理员添加成功");
			}
		}catch(Exception e) {
			baseResp = ExceptionHelper.createResponse(e, req);
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
