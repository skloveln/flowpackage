package com.bupt.flowpackage.biz.auth.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bupt.flowpackage.biz.auth.model.AdminAddOrEditReq;
import com.bupt.flowpackage.biz.auth.model.AdminRoleListReq;
import com.bupt.flowpackage.biz.auth.model.UserLoginWebRequest;
import com.bupt.flowpackage.biz.auth.service.AdminRoleService;
import com.bupt.flowpackage.common.domain.Page;
import com.bupt.flowpackage.common.domain.SessionVo;
import com.bupt.flowpackage.common.exception.BizException;
import com.bupt.flowpackage.common.session.SessionUtil;
import com.bupt.flowpackage.mybatis.account.admin.mapper.AdminMapper;
import com.bupt.flowpackage.mybatis.account.admin.model.Admin;
import com.bupt.flowpackage.mybatis.account.adminrole.mapper.AdminRoleMapper;
import com.bupt.flowpackage.mybatis.account.adminrole.model.AdminRole;
import com.bupt.flowpackage.mybatis.account.application.model.Application;
import com.bupt.flowpackage.mybatis.account.menu.mapper.MenuMapper;
import com.bupt.flowpackage.mybatis.account.role.mapper.RoleMapper;
import com.bupt.flowpackage.mybatis.account.role.model.Role;
import com.bupt.flowpackage.utils.PageRespUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private AdminRoleMapper adminRoleMapper;

	@Override
	public SessionVo checkLoginUserAndPwdService(UserLoginWebRequest req){
		AdminRole adminRoleReq = new AdminRole();
		adminRoleReq.setLoginName(req.getLoginName());
		AdminRole adminRole = adminMapper.selectAdminRoleInfo(adminRoleReq);
		if(adminRole == null) {
			BizException.warn(101, "用户名不存在!");
		}
		adminRoleReq.setPassword(req.getPassword());
		adminRole = adminMapper.selectAdminRoleInfo(adminRoleReq);
		if(adminRole == null) {
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
	
	public Page<AdminRole> getAdminListPage(AdminRoleListReq bizReq){
		AdminRole adminRole = new AdminRole();
		BeanUtils.copyProperties(bizReq, adminRole);
		
		PageHelper.startPage(bizReq.getPageNum(), bizReq.getPageSize());
		List<AdminRole> adminRoleList = adminMapper.selectAdminRoleInfoPage(adminRole);
		PageInfo<AdminRole> pageInfo = new PageInfo<AdminRole>(adminRoleList);
		
		return PageRespUtil.createPage(pageInfo);
	}
	
	public List<Role> getRoleList(){
		return roleMapper.selectRoleList();
	}
	@Transactional("account")
	public int adminAdd(AdminAddOrEditReq req){
		String pwd = req.getPassword();
		String rePwd = req.getRePassword();
		if(!StringUtils.equals(pwd, rePwd)) {
			BizException.warn(103, "密码和重复密码必须相同！");
		}
		
		SessionVo sessionVo = SessionUtil.getAdminSessionInfo();
		if(sessionVo == null) {
			BizException.warn("会话超时，请重新登录！");
		}
		
		AdminRole adminRoleReq = new AdminRole();
		adminRoleReq.setLoginName(req.getLoginName());
		AdminRole adminRoleResp = adminMapper.selectAdminRoleInfo(adminRoleReq);
		if(adminRoleResp != null) {
			BizException.warn(105, "用户已存在!");
		}
		
		Admin admin = new Admin();
		BeanUtils.copyProperties(req, admin);
		admin.setCreateUserName(sessionVo.getLoginName());
		adminMapper.insert(admin);
		
		AdminRole adminRole = new AdminRole();
		adminRole.setRoleId(req.getRoleId());
		adminRole.setAdminId(admin.getId());
		adminRoleMapper.deleteSelective(adminRole);
		adminRoleMapper.insert(adminRole);
		return admin.getId();
	}
	
	public boolean adminUpdate(AdminAddOrEditReq req) {
		
		return true;
	}
}
