package com.bupt.flowpackage.mybatis.account.menu.model;

import java.util.List;

import com.bupt.flowpackage.mybatis.account.application.model.Application;

/**
* @Description: 模块菜单
* @author wangdaojian
* @company 摩尔科技有限公司版权所有
* @date 2017年6月20日 下午4:36:51
 */
public class ApplicationMenu extends Application{

	private static final long serialVersionUID = 1L;
	/**模块id*/
	private Integer applicationId;
	/**菜单list*/
	private List<Menu> menuList;
	
	public Integer getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}
	public List<Menu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
}
