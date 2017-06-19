package com.bupt.flowpackage.common.session;

import javax.servlet.http.HttpSession;

import com.bupt.flowpackage.common.domain.SessionVo;

/**
* @Description: Session工具
* @author wangdaojian
* @company 摩尔科技有限公司版权所有
* @date 2017年6月19日 下午5:03:43
 */
public class SessionUtil {
	
	public static SessionVo getSessionInfo(HttpSession session) {
		SessionVo sessionInfo = (SessionVo) session.getAttribute("sessionVo");
		return sessionInfo;
	}
	
	public static void setSessionInfo(HttpSession session, SessionVo sessionVo) {
		session.setAttribute("sessionVo", sessionVo);
	}
	
	public static void clearSessionInfo(HttpSession session) {
		session.removeAttribute("sessionVo");
		session.invalidate();
	}
}
