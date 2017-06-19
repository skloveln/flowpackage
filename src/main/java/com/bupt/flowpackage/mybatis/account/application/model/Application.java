package com.bupt.flowpackage.mybatis.account.application.model;

import com.bupt.flowpackage.common.domain.BaseBean;

public class Application extends BaseBean{
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Short applicationCode;

    private String applicationName;

    private String applicationDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short getApplicationCode() {
        return applicationCode;
    }

    public void setApplicationCode(Short applicationCode) {
        this.applicationCode = applicationCode;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName == null ? null : applicationName.trim();
    }

    public String getApplicationDesc() {
        return applicationDesc;
    }

    public void setApplicationDesc(String applicationDesc) {
        this.applicationDesc = applicationDesc == null ? null : applicationDesc.trim();
    }
}