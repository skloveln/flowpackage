package com.bupt.flowpackage.common.session;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.bupt.flowpackage.common.domain.SessionVo;

public class SessionListener implements HttpSessionBindingListener {
	public static Map<Integer,SessionVo> ACTIVE_ADMIN = new HashMap<Integer,SessionVo>();//记录在线用户
	
	private Integer adminID;
	private SessionVo sessionVo;

	public SessionListener(int adminID,SessionVo sessionVo){
		setAdminID(adminID);
		setSessionVo(sessionVo);
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		ACTIVE_ADMIN.put(adminID, sessionVo);
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		ACTIVE_ADMIN.remove(adminID);
		SessionUtil.SESSION_MAP.remove(adminID);
	}

	public Integer getAdminID() {
		return adminID;
	}

	public void setAdminID(Integer adminID) {
		this.adminID = adminID;
	}

	public SessionVo getSessionVo() {
		return sessionVo;
	}

	public void setSessionVo(SessionVo sessionVo) {
		this.sessionVo = sessionVo;
	}
}
