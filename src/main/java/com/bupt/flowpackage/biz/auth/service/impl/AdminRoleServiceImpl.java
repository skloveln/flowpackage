package com.bupt.flowpackage.biz.auth.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bupt.flowpackage.biz.auth.model.AdminAddReq;
import com.bupt.flowpackage.biz.auth.model.AdminPwdReq;
import com.bupt.flowpackage.biz.auth.model.AdminRoleListReq;
import com.bupt.flowpackage.biz.auth.model.AdminUpdateReq;
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
import com.bupt.flowpackage.utils.RandomUtil;
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
		adminRoleReq.setAvailableFlag(true);
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
	
	public AdminRole getAdminRoleByKey(Integer adminId) {
		return adminMapper.selectByPrimaryKey(adminId);
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
	public int adminAdd(AdminAddReq req){
		SessionVo sessionVo = SessionUtil.getAdminSessionInfo();
		Admin admin = new Admin();
		if(sessionVo.isSuper() || SessionUtil.checkUrlAuth("admin-add")) {
			AdminRole adminRoleReq = new AdminRole();
			adminRoleReq.setLoginName(req.getLoginName());
			AdminRole adminRoleResp = adminMapper.selectAdminRoleInfo(adminRoleReq);
			if(adminRoleResp != null) {
				BizException.warn(105, "用户已存在!");
			}
			
			boolean isSuper = false;
			Role role = roleMapper.selectByPrimaryKey(req.getRoleId());
			if(role != null && role.getRoleLevel() == 1) {
				isSuper = true;
			}
			
			BeanUtils.copyProperties(req, admin);
			admin.setCreateUserName(sessionVo.getLoginName());
			admin.setIsSuper(isSuper);
			admin.setPassword(RandomUtil.getRandomStr(6));
			adminMapper.insert(admin);
			
			AdminRole adminRole = new AdminRole();
			adminRole.setAdminId(admin.getId());
			adminRoleMapper.deleteSelective(adminRole);
			adminRole.setRoleId(req.getRoleId());
			adminRoleMapper.insert(adminRole);
		}else {
			BizException.warn("你无权限添加用户！");
		}
		return admin.getId();
	}
	
	@Transactional("account")
	public boolean adminUpdate(AdminUpdateReq req) {
		SessionVo sessionVo = SessionUtil.getAdminSessionInfo();
		if(sessionVo.isSuper() || SessionUtil.checkUrlAuth("admin-edit") || req.getAdminId() == sessionVo.getAdminId()){
			Admin admin = adminMapper.selectByPrimaryKey(req.getAdminId());
			if(admin == null) {
				BizException.warn("用户不存在!");
			}else {
				//更新管理员信息
				Admin adminInfo = new Admin();
				BeanUtils.copyProperties(req, adminInfo);
				adminInfo.setId(req.getAdminId());
				//是否为超级管理员
				Boolean isSuper = false;
				Role role = roleMapper.selectByPrimaryKey(req.getRoleId());
				if(role != null && role.getRoleLevel() == 1) {
					isSuper = true;
				}
				adminInfo.setIsSuper(isSuper);
				adminMapper.updateByPrimaryKeySelective(adminInfo);
				//更新管理员角色信息
				AdminRole adminRole = new AdminRole();
				adminRole.setAdminId(req.getAdminId());
				adminRole.setRoleId(req.getRoleId());
				adminRoleMapper.updateRoleByAdminId(adminRole);
			}
		}else {
			BizException.warn("你无权限修改该用户信息！");
		}
		return true;
	}
	
	public boolean adminUpdatePwd(AdminPwdReq req){
		SessionVo sessionVo = SessionUtil.getAdminSessionInfo();
		if(sessionVo.isSuper() || SessionUtil.checkUrlAuth("admin-pass") || req.getAdminId() == sessionVo.getAdminId()){
			Admin admin = adminMapper.selectByPrimaryKey(req.getAdminId());
			if(admin == null) {
				BizException.warn("用户不存在!");
			}else {
				if(req.isSelf() && StringUtils.isBlank(req.getOldpassword())) {
					BizException.warn("原始密码不能为空!");
				}
				if(!StringUtils.equals(req.getPassword(), req.getRepassword())) {
					BizException.warn("重复密码必须和新密码一致");
				}
				//更新管理员信息
				Admin adminInfo = new Admin();
				adminInfo.setId(req.getAdminId());
				adminInfo.setPassword(req.getPassword());
				adminMapper.updateByPrimaryKeySelective(adminInfo);
			}
		}else {
			BizException.warn("你无权限修改用户密码！");
		}
		return true;
	}
	
	public int updateStatus(Integer adminId, boolean status) {
		Admin admin = new Admin();
		admin.setId(adminId);
		admin.setAvailableFlag(status);
		return adminMapper.updateByPrimaryKeySelective(admin);
	}

	@Override
	@Transactional("account")
	public int adminDelete(Integer adminId) {
		int deleteNum = 0;
		AdminRole adminRole = adminMapper.selectByPrimaryKey(adminId);
		if(adminRole == null) {
			BizException.warn("用户不存在!");
		}else {
			adminRoleMapper.deleteSelective(adminRole);
			deleteNum = adminMapper.deleteByPrimaryKey(adminRole.getAdminId());
		}
		return deleteNum;
	}
}
