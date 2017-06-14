package com.bupt.flowpackage.mybatis.account.application.model;

import java.io.Serializable;

public class Application implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String applicationCode;

    private String applicationName;

    private String applicationDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplicationCode() {
        return applicationCode;
    }

    public void setApplicationCode(String applicationCode) {
        this.applicationCode = applicationCode == null ? null : applicationCode.trim();
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