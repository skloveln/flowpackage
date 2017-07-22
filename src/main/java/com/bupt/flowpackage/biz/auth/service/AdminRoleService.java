package com.bupt.flowpackage.biz.auth.service;

import java.util.List;

import com.bupt.flowpackage.biz.auth.model.AdminAddReq;
import com.bupt.flowpackage.biz.auth.model.AdminRoleListReq;
import com.bupt.flowpackage.biz.auth.model.AdminUpdateReq;
import com.bupt.flowpackage.biz.auth.model.UserLoginWebRequest;
import com.bupt.flowpackage.common.domain.Page;
import com.bupt.flowpackage.common.domain.SessionVo;
import com.bupt.flowpackage.mybatis.account.adminrole.model.AdminRole;
import com.bupt.flowpackage.mybatis.account.application.model.Application;
import com.bupt.flowpackage.mybatis.account.role.model.Role;

/**
 * <p>Description:账号角色权限接口</p>
 * <p>Company:摩尔科技</p>
 * @author daojian
 * @date 2017年6月12日 下午10:28:25
 */
public interface AdminRoleService {
	
	/**
	 * <p>校验登陆用户名密码</p>   
	 * @param @param req
	 * @param @return      
	 * @return BaseResponse<Boolean>
	 */
	public SessionVo checkLoginUserAndPwdService(UserLoginWebRequest req);
	
	/**
	* @Description 获取管理员列表
	* @param @param adminRoleReq
	* @param @param pageSize
	* @param @param pageNum
	* @param @return
	* @return Page<AdminRole>
	 */
	public Page<AdminRole> getAdminListPage(AdminRoleListReq bizReq);
	
	/**
	 * <p>获取角色列表</p>   
	 * @param @return      
	 * @return List<Role>
	 */
	public List<Role> getRoleList();
	
	/**
	 * <p>管理员添加</p>   
	 * @param @param req
	 * @param @return      
	 * @return int adminId
	 */
	public int adminAdd(AdminAddReq req);
	/**
	 * <p>管理员修改</p>   
	 * @param @param req
	 * @param @return      
	 * @return boolean
	 */
	public boolean adminUpdate(AdminUpdateReq req); 
	
	/**
	* @Description 根据角色获取模块菜单
	* @param @return
	* @return List<Application>
	 */
	public List<Application> getApplicationMenuByRoleId(Integer roleId);
	/**
	* @Description 超级管理员获取所有的模块菜单
	* @param @return
	* @return List<Application>
	 */
	public List<Application> getAllApplicationMenu();
	
}
