package com.bupt.flowpackage.mybatis.account.menu.model;

import java.io.Serializable;

public class Menu implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String menuCode;

    private Integer applicationId;

    private Integer menuParentId;

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

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode == null ? null : menuCode.trim();
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
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