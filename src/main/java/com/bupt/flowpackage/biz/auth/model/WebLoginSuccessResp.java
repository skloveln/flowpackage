package com.bupt.flowpackage.biz.auth.model;

import java.util.List;

import com.bupt.flowpackage.common.domain.BaseBean;

/**
* @Description: 用户登录成功，进入主页返回的信息，包括菜单列表，用户权限组信息
* @author wangdaojian
* @company 摩尔科技有限公司版权所有
* @date 2017年6月20日 下午2:10:33
 */
public class WebLoginSuccessResp extends BaseBean{

	private static final long serialVersionUID = 1L;
	/**管理员角色信息*/
	private AdminVo adminInfo;
	/**菜单列表*/
	private List<MenuVo> menus;
	
	public AdminVo getAdminInfo() {
		return adminInfo;
	}
	public void setAdminInfo(AdminVo adminInfo) {
		this.adminInfo = adminInfo;
	}
	public List<MenuVo> getMenus() {
		return menus;
	}
	public void setMenus(List<MenuVo> menus) {
		this.menus = menus;
	}
}
