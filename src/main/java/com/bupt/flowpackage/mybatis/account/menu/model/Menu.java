package com.bupt.flowpackage.mybatis.account.menu.model;

import java.util.List;

import com.bupt.flowpackage.common.domain.BaseBean;

public class Menu extends BaseBean{
	private static final long serialVersionUID = 1L;

	private Integer id;
	/**权限主体id*/
	private Integer masterId;
	
    private Short menuNo;

    private Short applicationCode;

    private Short menuParentNo;

    private Short menuOrder;

    private String menuName;

    private String menuUrl;

    private String menuIcon;

    private Boolean isVisible;

    private Boolean isLeaf;
    /**子菜单*/
    private List<Menu> children;
    
    public Integer getMasterId() {
		return masterId;
	}

	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getMenuNo() {
        return menuNo;
    }

    public void setMenuNo(Short menuNo) {
        this.menuNo = menuNo;
    }

    public Short getApplicationCode() {
        return applicationCode;
    }

    public void setApplicationCode(Short applicationCode) {
        this.applicationCode = applicationCode;
    }

    public Short getMenuParentNo() {
        return menuParentNo;
    }

    public void setMenuParentNo(Short menuParentNo) {
        this.menuParentNo = menuParentNo;
    }

    public Short getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Short menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }

    public Boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Boolean isVisible) {
        this.isVisible = isVisible;
    }

    public Boolean getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Boolean isLeaf) {
        this.isLeaf = isLeaf;
    }
}