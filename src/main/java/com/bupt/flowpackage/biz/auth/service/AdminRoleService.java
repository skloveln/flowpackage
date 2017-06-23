package com.bupt.flowpackage.biz.auth.service;

import java.util.List;

import com.bupt.flowpackage.biz.auth.model.UserLoginWebRequest;
import com.bupt.flowpackage.common.domain.SessionVo;
import com.bupt.flowpackage.mybatis.account.application.model.Application;

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
