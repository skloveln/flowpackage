package com.bupt.flowpackage.biz.auth.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.bupt.flowpackage.common.domain.BaseRequest;

/**
* @Description: 管理员登陆web请求对象
* @author wangdaojian
* @company 摩尔科技有限公司版权所有
* @date 2017年6月18日 下午1:01:41
*/
public class UserLoginWebRequest extends BaseRequest{

	private static final long serialVersionUID = 1L;
	/**登陆账号*/
	@NotBlank(message="用户名不能为空！")
	private String loginName;
	/**登陆密码*/
	@NotBlank(message="密码不能为空！" )
	@Size(min=5, message="密码最少5位!")
	private String password;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
