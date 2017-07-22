package com.bupt.flowpackage.biz.auth.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.bupt.flowpackage.common.domain.BaseRequest;

public class AdminUpdateReq  extends BaseRequest{
	private static final long serialVersionUID = 1L;
	/**管理员id*/
	@NotNull
	private Integer adminId;
	/**角色id*/
	@NotNull
	private Integer roleId;
	/**密码*/
	private String password;
	/**重复密码*/
	@NotBlank
	private String rePassword;
	/**真实姓名*/
    private String realName;
    /**手机号*/
    private String mobile;
    /**邮箱*/
    private String email;
    
    private String adminDesc;
    
	public String getAdminDesc() {
		return adminDesc;
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
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
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
