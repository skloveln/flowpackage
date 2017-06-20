package com.bupt.flowpackage.mybatis.account.admin.model;

/**管理员角色信息合集*/
public class AdminRole extends Admin{

	private static final long serialVersionUID = 1L;
	/**管理员id*/
	private Integer adminId;
	/**角色id*/
	private Integer roleId;
	/**角色名称*/
	private String roleName;
	
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
