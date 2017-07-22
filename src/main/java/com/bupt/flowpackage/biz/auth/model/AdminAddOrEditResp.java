package com.bupt.flowpackage.biz.auth.model;

import java.util.List;

import com.bupt.flowpackage.common.domain.BaseBean;
import com.bupt.flowpackage.mybatis.account.admin.model.Admin;
import com.bupt.flowpackage.mybatis.account.role.model.Role;
/**
* @Description: 管理员信息修改响应
* @author wangdaojian
* @company 摩尔科技有限公司版权所有
* @date 2017年7月22日 上午10:32:37
 */
public class AdminAddOrEditResp extends BaseBean{
	private static final long serialVersionUID = 1L;

	private Admin admin;
	
	private List<Role> roleList;
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
}
