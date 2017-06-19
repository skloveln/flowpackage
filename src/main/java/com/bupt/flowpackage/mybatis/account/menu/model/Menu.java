package com.bupt.flowpackage.mybatis.account.menu.model;

import com.bupt.flowpackage.common.domain.BaseBean;

public class Menu extends BaseBean{
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Short menuNo;

    private Short applicationCode;

    private Short menuParentNo;

    private Short menuOrder;

    private String munuName;

    private String munuUrl;

    private String menuIcon;

    private Boolean isVisible;

    private Boolean isLeaf;

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

    public String getMunuName() {
        return munuName;
    }

    public void setMunuName(String munuName) {
        this.munuName = munuName == null ? null : munuName.trim();
    }

    public String getMunuUrl() {
        return munuUrl;
    }

    public void setMunuUrl(String munuUrl) {
        this.munuUrl = munuUrl == null ? null : munuUrl.trim();
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