package com.bupt.flowpackage.biz.auth.model;

import com.bupt.flowpackage.common.domain.BaseRequest;

public class AdminRoleListReq extends BaseRequest{

	private static final long serialVersionUID = 1L;
	/**手机号*/
	private String mobile;
	/**登录账号*/
	private String loginName;
	/**真实姓名*/
	private String realName;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	
}
