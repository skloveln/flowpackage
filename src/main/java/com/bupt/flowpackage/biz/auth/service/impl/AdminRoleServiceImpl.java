package com.bupt.flowpackage.biz.auth.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bupt.flowpackage.biz.auth.model.UserLoginWebRequest;
import com.bupt.flowpackage.biz.auth.service.AdminRoleService;
import com.bupt.flowpackage.common.domain.SessionVo;
import com.bupt.flowpackage.common.exception.BizException;
import com.bupt.flowpackage.mybatis.account.admin.mapper.AdminMapper;
import com.bupt.flowpackage.mybatis.account.admin.model.Admin;
import com.bupt.flowpackage.mybatis.account.admin.model.AdminRole;
import com.bupt.flowpackage.mybatis.account.application.model.Application;
import com.bupt.flowpackage.mybatis.account.menu.mapper.MenuMapper;

/**
 * <p>Description:管理员权限角色接口服务</p>
 * <p>Company:摩尔科技</p>
 * @author daojian
 * @date 2017年6月12日 下午10:29:45
 */
@Service
public class AdminRoleServiceImpl implements AdminRoleService{
	
	@Resource
	private AdminMapper adminMapper;
	@Resource
	private MenuMapper menuMapper;

	@Override
	public SessionVo checkLoginUserAndPwdService(UserLoginWebRequest req){
		Admin adminReq = new Admin();
		adminReq.setLoginName(req.getLoginName());
		AdminRole adminRole = adminMapper.selectAdminRoleInfo(adminReq);
		if(adminRole == null) {
			BizException.warn(101, "用户名不存在!");
		}else if(!(req.getPassword().equals(adminRole.getPassword()))) {
			BizException.warn(102, "密码不正确，请重新输入!");
		}
		SessionVo sessionVo = new SessionVo();
		sessionVo.setAdminId(adminRole.getAdminId());
		sessionVo.setLoginName(adminRole.getLoginName());
		sessionVo.setRoleName(adminRole.getRoleName());
		sessionVo.setRoleId(adminRole.getRoleId());
		sessionVo.setSuper(adminRole.getIsSuper());
		return sessionVo;
	}

	@Override
	public List<Application> getApplicationMenuByRoleId(Integer roleId) {
		return menuMapper.selectApplicationListByRoleId(roleId);
	}
	
	@Override
	public List<Application> getAllApplicationMenu() {
		return menuMapper.selectAllApplicationList();
	}
	
}
