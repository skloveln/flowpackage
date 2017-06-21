package com.bupt.flowpackage.common.session;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bupt.flowpackage.common.domain.SessionVo;

/**
* @Description: Session工具
* @author wangdaojian
* @company 摩尔科技有限公司版权所有
* @date 2017年6月19日 下午5:03:43
 */
public class SessionUtil {
	
	public static Logger logger = LoggerFactory.getLogger(SessionUtil.class);
	
	public static final String ADMIN_SESSION = "adminSession";
	public static final String ACTIVE_ADMIN_LISTENER = "activeAdminListener";
	//用于同个账号只能一台电脑登陆，或者可以主动踢掉用户
	public static Map<Integer, HttpSession> SESSION_MAP = new HashMap<Integer, HttpSession>();
	
	public static HttpServletRequest getRequest(){
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return sra == null ? null : sra.getRequest();
	}
	
	public static HttpSession getSession(){
		HttpServletRequest req = getRequest();
		return req == null ? null : req.getSession();
	}
	
	/**
	 * <p>获取当前session</p>   
	 * @param @return      
	 * @return SessionVo
	 */
	public static SessionVo getAdminSessionInfo() {
		return (SessionVo)getSession().getAttribute(ADMIN_SESSION);
	}
	
	/**
	 * <p>设置session</p>   
	 * @param @param sessionVo      
	 * @return void
	 */
	public static void setAdminSessionInfo(SessionVo sessionVo) {
		getSession().setAttribute(ADMIN_SESSION, sessionVo);
	}
	
	public static void login(SessionVo sessionVo) {
		if (SESSION_MAP.containsKey(sessionVo.getAdminId())) {// 如果已经登录
			HttpSession session = SESSION_MAP.get(sessionVo.getAdminId());
			if (session != null) {
				session.removeAttribute(ADMIN_SESSION);
				session.invalidate();// 迫使原来 session 失效
			}
			SESSION_MAP.remove(sessionVo.getAdminId());
			logger.info("loginName={}从另一个电脑登陆, 踢掉在线用户!", sessionVo.getLoginName());
		}
		SESSION_MAP.put(sessionVo.getAdminId(), getSession());
		SessionListener listener = new SessionListener(sessionVo.getAdminId(), sessionVo);// 设置session监听
		getSession().setAttribute(ADMIN_SESSION, sessionVo);
		getSession().setAttribute(ACTIVE_ADMIN_LISTENER, listener);
	}
	
	public static void logout() {
		SessionVo sessionInfo = getAdminSessionInfo();
		if(sessionInfo != null){
			SESSION_MAP.remove(sessionInfo.getAdminId());// 该操作在监听器中实现
			getSession().removeAttribute(ADMIN_SESSION);
			getSession().removeAttribute(ACTIVE_ADMIN_LISTENER);
			getSession().invalidate();
		}
	}
	/**
	 * <p>主动踢掉某个在线用户</p>   
	 * @param @param adminId      
	 * @return void
	 */
	public static void logout(Integer adminId) {
		HttpSession session = SESSION_MAP.get(adminId);
		if(session != null){
			session.removeAttribute(ADMIN_SESSION);
			session.removeAttribute(ACTIVE_ADMIN_LISTENER);
			session.invalidate();
			SESSION_MAP.remove(adminId);
		}
	}
	
}
