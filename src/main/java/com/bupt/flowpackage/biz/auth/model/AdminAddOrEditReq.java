package com.bupt.flowpackage.biz.auth.model;

import com.bupt.flowpackage.common.domain.BaseRequest;

public class AdminAddOrEditReq extends BaseRequest{

	private static final long serialVersionUID = 1L;
	private String loginName;
	/**管理员id*/
	private Integer adminId;
	/**角色id*/
	private Integer roleId;
	/**密码*/
	private String password;
	/**重复密码*/
	private String repassword;
	/**旧密码*/
	private String oldpassword;
	/**真实姓名*/
    private String realName;
    /**手机号*/
    private String mobile;
    /**邮箱*/
    private String email;
    
    private String adminDesc;
    /**是否为自己修改*/
    private boolean self;
    
	public boolean isSelf() {
		return self;
	}
	public void setSelf(boolean self) {
		this.self = self;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getAdminDesc() {
		return adminDesc;
	}
	public void setAdminDesc(String adminDesc) {
		this.adminDesc = adminDesc;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
