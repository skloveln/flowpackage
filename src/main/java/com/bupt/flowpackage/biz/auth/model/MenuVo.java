package com.bupt.flowpackage.biz.auth.model;

import java.util.List;

import com.bupt.flowpackage.mybatis.account.menu.model.Menu;

public class MenuVo extends Menu{

	private static final long serialVersionUID = 1L;
	/**子菜单*/
	private List<Menu> children;
	
	public List<Menu> getChildren() {
		return children;
	}
	
	public void setChildren(List<Menu> children) {
		this.children = children;
	}
}
