package com.bupt.flowpackage.mybatis.account.privilege.model;

import com.bupt.flowpackage.common.domain.BaseBean;

public class Privilege extends BaseBean{
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Byte masterType;

    private Integer masterId;

    private Byte accessType;

    private Integer accessNo;

    private Boolean isOperatation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getMasterType() {
        return masterType;
    }

    public void setMasterType(Byte masterType) {
        this.masterType = masterType;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public Byte getAccessType() {
        return accessType;
    }

    public void setAccessType(Byte accessType) {
        this.accessType = accessType;
    }

    public Integer getAccessNo() {
		return accessNo;
	}

	public void setAccessNo(Integer accessNo) {
		this.accessNo = accessNo;
	}

	public Boolean getIsOperatation() {
        return isOperatation;
    }

    public void setIsOperatation(Boolean isOperatation) {
        this.isOperatation = isOperatation;
    }
}