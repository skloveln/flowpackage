package com.bupt.flowpackage.biz.auth.model;

import com.bupt.flowpackage.mybatis.account.admin.model.Admin;

public class AdminVo extends Admin{

	private static final long serialVersionUID = 1L;
	/**角色名*/
	private String roleName;
	/**角色id*/
	private Integer roleId;
	/**管理员id*/
	private Integer adminId;
	
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
