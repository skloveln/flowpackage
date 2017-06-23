package com.bupt.flowpackage.common.session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bupt.flowpackage.common.domain.SessionVo;
import com.bupt.flowpackage.mybatis.account.application.model.Application;
import com.bupt.flowpackage.mybatis.account.menu.model.Menu;

/**
* @Description: Session工具
* @author wangdaojian
* @company 摩尔科技有限公司版权所有
* @date 2017年6月19日 下午5:03:43
 */
public class SessionUtil {
	
	private static Logger logger = LoggerFactory.getLogger(SessionUtil.class);
	
	private static final String ADMIN_SESSION = "adminSession";
	private static final String ACTIVE_ADMIN_LISTENER = "activeAdminListener";
	//全局模块菜单信息，根据角色id分组
	private static Map<Integer, List<Application>> APPLICATION_MAP = new HashMap<Integer, List<Application>>();
	//菜单url
	private static Map<Integer, List<String>> MENU_URL_MAP = new HashMap<Integer, List<String>>();
	
	//用于同个账号只能一台电脑登陆，或者可以主动踢掉用户
	private static Map<Integer, HttpSession> SESSION_MAP = new HashMap<Integer, HttpSession>();
	
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
	
	public static void setApplicationList(List<Application> applicationList) {
		APPLICATION_MAP.put(getAdminSessionInfo().getRoleId(), applicationList);
		MENU_URL_MAP.put(getAdminSessionInfo().getRoleId(), loadAllMenuUrl(applicationList));
	}
	/**
	 * <p>把权限内的菜单url提取出来</p>   
	 * @param @param applicationList
	 * @param @return      
	 * @return List<String>
	 */
	private static List<String> loadAllMenuUrl(List<Application> applicationList) {
		List<String> menuUrlList = new ArrayList<String>();
		for(int i=0; i < applicationList.size(); i++) {
			Application application = applicationList.get(i);
			String applicationUrl = application.getApplicationUrl();
			menuUrlList.add(applicationUrl);
			List<Menu> menuList = application.getMenuList();
			for(int j=0; j<menuList.size(); j++) {
				List<Menu> children = menuList.get(j).getChildren();
				for(int z=0; z<children.size(); z++) {
					Menu child = children.get(z);
					String menuUrl = child.getMenuUrl();
					boolean isLeaf = child.getIsLeaf();
					if(isLeaf && menuUrl.contains(".html")) {
						menuUrlList.add(menuUrl.substring(0, menuUrl.indexOf(".html")));
					}
				}
			}
		}
		return menuUrlList;
	}
	
	public static List<Application> getApplicationList() {
		return APPLICATION_MAP.get(getAdminSessionInfo().getRoleId());
	}
	/**
	 * <p>根据applicationCode查询code</p>   
	 * @param @param code
	 * @param @return      
	 * @return Application
	 */
	public static Application getApplicationByCode(Short code) {
		List<Application> appList = getApplicationList();
		for(int i=0; i < appList.size(); i++) {
			Application temp = appList.get(i);
			Short applicationCode = temp.getApplicationCode();
			if(code.equals(applicationCode)) {
				return temp;
			}
		}
		return null;
	}
	/***
	 * <p>检查url是否有权限</p>   
	 * @param @param url
	 * @param @return      
	 * @return boolean
	 */
	public static boolean checkUrlAuth(String url) {
		List<String> menuUrlList = MENU_URL_MAP.get(getAdminSessionInfo().getRoleId());
		if(menuUrlList != null && menuUrlList.size() > 0 && menuUrlList.contains(url)) {
			return true;
		}
		return false;
	}
}
