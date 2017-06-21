package com.bupt.flowpackage.common.interceptors;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bupt.flowpackage.biz.auth.model.WebGlobalVo;
import com.bupt.flowpackage.common.domain.SessionVo;
import com.bupt.flowpackage.common.session.SessionUtil;
import com.bupt.flowpackage.mybatis.account.application.model.Application;

public class LoginInteceptor  extends HandlerInterceptorAdapter{
	public static Logger logger = LoggerFactory.getLogger(LoginInteceptor.class);
	//web全局信息，访问任何页面都会用到
	private static final String GLOBAL_INFO = "global";
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		SessionVo sessionInfo = SessionUtil.getAdminSessionInfo();
		if(sessionInfo == null) {
			String uri = request.getRequestURI();
			logger.info("\n用户访问url={} 因未登陆或session过期, 强制跳转到tologin登陆页", uri);
			response.sendRedirect("tologin");
			return false;
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		WebGlobalVo webGlobalVo = new WebGlobalVo();
		SessionVo sessionInfo = SessionUtil.getAdminSessionInfo();
		if(sessionInfo != null) {
			webGlobalVo.setAdminInfo(sessionInfo);
		}
		List<Application> applicationList = SessionUtil.getApplicationList();
		if(applicationList != null && applicationList.size() > 0) {
			webGlobalVo.setApplicationList(applicationList);
		}
		webGlobalVo.setApplicationList(applicationList);
		modelAndView.addObject(GLOBAL_INFO, webGlobalVo);
	}
}
