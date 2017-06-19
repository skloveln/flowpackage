package com.bupt.flowpackage.mybatis.account.button.model;

import com.bupt.flowpackage.common.domain.BaseBean;

public class Button extends BaseBean{
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Short btnNo;

    private String btnName;

    private String btnClass;

    private String btnIcon;

    private Integer menuNo;

    private Boolean initStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getBtnNo() {
        return btnNo;
    }

    public void setBtnNo(Short btnNo) {
        this.btnNo = btnNo;
    }

    public String getBtnName() {
        return btnName;
    }

    public void setBtnName(String btnName) {
        this.btnName = btnName == null ? null : btnName.trim();
    }

    public String getBtnClass() {
        return btnClass;
    }

    public void setBtnClass(String btnClass) {
        this.btnClass = btnClass == null ? null : btnClass.trim();
    }

    public String getBtnIcon() {
        return btnIcon;
    }

    public void setBtnIcon(String btnIcon) {
        this.btnIcon = btnIcon == null ? null : btnIcon.trim();
    }

    public Integer getMenuNo() {
        return menuNo;
    }

    public void setMenuNo(Integer menuNo) {
        this.menuNo = menuNo;
    }

    public Boolean getInitStatus() {
        return initStatus;
    }

    public void setInitStatus(Boolean initStatus) {
        this.initStatus = initStatus;
    }
}