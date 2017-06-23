package com.bupt.flowpackage.mybatis.account.application.model;

import java.util.List;

import com.bupt.flowpackage.common.domain.BaseBean;
import com.bupt.flowpackage.mybatis.account.menu.model.Menu;

public class Application extends BaseBean{
	private static final long serialVersionUID = 1L;
	private Integer id;
	/**权限主体id*/
	private Integer masterId;
	
    private Short applicationCode;

    private String applicationName;
    
    private String applicationIcon;
    
    private String applicationUrl;

    private String applicationDesc;
    /**菜单list*/
    private List<Menu> menuList;
    
    public String getApplicationIcon() {
		return applicationIcon;
	}

	public void setApplicationIcon(String applicationIcon) {
		this.applicationIcon = applicationIcon;
	}

	public String getApplicationUrl() {
		return applicationUrl;
	}

	public void setApplicationUrl(String applicationUrl) {
		this.applicationUrl = applicationUrl;
	}

	public Integer getMasterId() {
		return masterId;
	}

	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

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