package com.bupt.flowpackage.common.interceptors;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bupt.flowpackage.biz.auth.model.WebGlobalVo;
import com.bupt.flowpackage.common.domain.BaseResponse;
import com.bupt.flowpackage.common.domain.SessionVo;
import com.bupt.flowpackage.common.enums.ResultCode;
import com.bupt.flowpackage.common.session.SessionUtil;
import com.bupt.flowpackage.mybatis.account.application.model.Application;

public class LoginInteceptor  extends HandlerInterceptorAdapter{
	public static Logger logger = LoggerFactory.getLogger(LoginInteceptor.class);
	private static String API_PATH = "/**/api/**";
	
	//web全局信息，访问任何页面都会用到
	private static final String GLOBAL_INFO = "global";
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		SessionVo sessionInfo = SessionUtil.getAdminSessionInfo();
		String uri = request.getRequestURI();
		
		if(handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler; 
			ResponseBody hasResponseBody = handlerMethod.getMethodAnnotation(ResponseBody.class);
			if(sessionInfo == null) {
				if(hasResponseBody != null) {
					BaseResponse<String> baseResp = new BaseResponse<String>(ResultCode.Result_NO_SESSION);
					logger.info("\n用户访问url={} 因未登陆或session过期, 返回超时错误信息:{}", uri, baseResp);
					
					response.setCharacterEncoding("UTF-8");
					response.setHeader("Content-type","text/html;charset=UTF-8");
					PrintWriter writer = response.getWriter();
					writer.write(baseResp.toString());
				} else {
					logger.info("\n用户访问url={} 因未登陆或session过期, 强制跳转到tologin登陆页", uri);
					response.sendRedirect(request.getContextPath() + "/tologin");
				}	
				return false;
			}else {
				String currentUri = getSimpleUri(uri);
				//权限校验
				if(hasResponseBody != null) {
					PathMatcher matcher = new AntPathMatcher();
					if(!matcher.match(API_PATH, uri) && !SessionUtil.checkUrlAuth(currentUri)){
						BaseResponse<String> baseResp = new BaseResponse<String>(ResultCode.Result_NO_AUTH);
						logger.info("\n用户访问url={} 该用户loginName={}无权限，返回提示信息！", uri, sessionInfo.getLoginName());
						response.setCharacterEncoding("UTF-8");
						response.setHeader("Content-type","text/html;charset=UTF-8");
						PrintWriter writer = response.getWriter();
						writer.write(baseResp.toString());
						return false;
					}
				}else {
					if(!SessionUtil.checkUrlAuth(currentUri)) {
						logger.info("\n用户={} 访问url={} 因无权限, 强制跳转到无权限页面", sessionInfo.getLoginName(), uri);
						request.getRequestDispatcher("/error/noauth").forward(request, response);
					}
				}
			}
		}
		return true;
	}
	
	private String getSimpleUri(String url) {
		String currentUrl;
		if(url.contains(".")) {
			currentUrl = url.substring(url.lastIndexOf("/") + 1, url.indexOf("."));
		}else {
			currentUrl = url.substring(url.lastIndexOf("/") + 1);
		}
		return currentUrl;
	}	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		WebGlobalVo webGlobalVo = new WebGlobalVo();
		//添加管理员信息
		if(modelAndView != null) {
			SessionVo sessionInfo = SessionUtil.getAdminSessionInfo();
			webGlobalVo.setAdminInfo(sessionInfo);
			//获取所有模块
			List<Application> applicationList = SessionUtil.getApplicationList();
			if(applicationList != null && applicationList.size() > 0) {
				webGlobalVo.setApplicationList(applicationList);
			}
			//添加菜单list
			Application application = SessionUtil.getApplicationByCode(sessionInfo.getApplicationCode());
			if(application != null && application.getMenuList() != null) {
				webGlobalVo.setMenuList(application.getMenuList());
			}
			
			//检查uri是否有权限
			String uri = request.getRequestURI();
			String contextPath = request.getContextPath();
			int start = contextPath.length();
			int end = uri.lastIndexOf("/");
			String parentUri = uri.substring(start, end);
			webGlobalVo.setCurrentParentUrl(parentUri);
			
			//----/flowpackage/index
			String currentUri = getSimpleUri(uri);
			webGlobalVo.setCurrentUrl(currentUri + ".html");
			if(modelAndView != null && SessionUtil.checkUrlAuth(currentUri)) {
				modelAndView.addObject(GLOBAL_INFO, webGlobalVo);
			}
		}
	}
}
