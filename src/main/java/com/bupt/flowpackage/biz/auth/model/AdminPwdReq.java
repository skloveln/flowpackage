package com.bupt.flowpackage.biz.auth.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;
import com.bupt.flowpackage.common.domain.BaseRequest;

public class AdminPwdReq extends BaseRequest{

	private static final long serialVersionUID = 1L;
	/**管理员id*/
	@NotNull(message="管理员id不能为空")
	private Integer adminId;
	/**旧密码*/
	private String oldpassword;
	/**新密码*/
	@NotBlank(message="密码不能为空")
	@Pattern(regexp="^\\w{5,20}$", message="密码必须是5-20个字母或数字或下划线")
	private String password;
	/**重复密码*/
	@NotBlank(message="重复密码不能为空")
	@Pattern(regexp="^\\w{5,20}$", message="重复密码必须是5-20个字母或数字或下划线")
	private String repassword;
	/**是否为自己修改*/
	private boolean self;
	
	public boolean isSelf() {
		return self;
	}
	public void setSelf(boolean self) {
		this.self = self;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
}
