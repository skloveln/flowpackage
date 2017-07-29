package com.bupt.flowpackage.common.interceptors;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.ui.ModelMap;
import org.springframework.util.StopWatch;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bupt.flowpackage.common.domain.BaseRequest;


public class RequestParameterInteceptor extends HandlerInterceptorAdapter {
	public static Logger logger = LoggerFactory.getLogger(RequestParameterInteceptor.class);
	
	private ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<StopWatch>();
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		StopWatch stopWatch = new StopWatch(handler.toString());
		stopWatchLocal.set(stopWatch);
		stopWatch.start(handler.toString());

		String referer = request.getHeader("Referer");
		String uri = request.getRequestURI();
		
		boolean hasBaseRequest = false;
		if(handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;  
			MethodParameter[] methodParams = handlerMethod.getMethodParameters();
			//如果是ajax请求，url=/*/api/** 则用日志aop打印日志，否则打印request里的日志
			for(MethodParameter param : methodParams) {
				Class<?> paramType = param.getParameterType();
				if(BaseRequest.class.isAssignableFrom(paramType)) {
					hasBaseRequest = true;
					break;
				}
			}
		}
		String method = request.getMethod();
		StringBuilder sb = new StringBuilder("\n********toUri=" + uri + "; fromUrl=" + referer + "**********");
		if(!hasBaseRequest) {
			sb.append("\n**********本次" + method + "请求的参数如下************");
			Enumeration<String> en = request.getParameterNames();
			while (en.hasMoreElements()) {
				String name = en.nextElement();
				String values[] = request.getParameterValues(name);
				
				for (int i = 0; i < values.length; i++) {
					sb.append("\n\t参数名getParameter：" + name + ",参数值：" + values[i]);

					//对所有请求参数进行跨站攻击检查
					String param = values[i].trim().toLowerCase();
					if (param.matches(".*\\(\\)&%<acx><script ?>prompt(.*)</script>.*")
							|| param.matches(".*style='acu:expre/\\*{2}/ssion\\(prompt\\(.*\\)\\)'bad=.*")
							|| param.matches(".*><iframe onload=alert\\(\\)>.*")) {
						logger.info("请求参数进行跨站攻击, {}={}", name, param);
						response.sendError(500);
						return false;
					}

					// 过滤sql转换函数
					if (values[i].contains("ascii(") || values[i].contains("ascii (") || values[i].contains("chr(")
							|| values[i].contains("chr (")) {
						logger.info("1.出现sql转换函数！关键词=" + values[i]);
						return false;
					}
					// 过滤sql关键字
					if (values[i].contains("alter") || values[i].contains("create") || values[i].contains("truncate")
							|| values[i].contains("drop") || values[i].contains("lock table")
							|| values[i].contains("insert") || values[i].contains("update") || values[i].contains("delete")
							|| values[i].contains("select") || values[i].contains("grant") || values[i].contains("../")
							|| values[i].contains("/etc")) {
						logger.info("2.出现sql关键字！关键词=" + values[i]);
						return false;
					}
				}
			}
		}
		logger.info(sb.toString());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String uri = request.getRequestURI();
		StopWatch stopWatch = stopWatchLocal.get();
		if (stopWatch.isRunning()) {
			stopWatch.stop();
		}
		//如果有model，则打印model里的信息
		if(modelAndView != null) {
			ModelMap mv = modelAndView.getModelMap();
			if(mv != null && mv.get("resp") != null) {
				logger.info("\n访问url={} 返回model.resp={}", uri, mv.get("resp"));
			}
		}
		
		logger.info("\n=====访问链接[" + uri + "]，请求所耗时间：" + stopWatch.getTotalTimeMillis() + "毫秒\n");
	}

}
