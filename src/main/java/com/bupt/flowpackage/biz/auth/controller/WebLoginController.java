package com.bupt.flowpackage.biz.auth.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bupt.flowpackage.biz.auth.model.UserLoginWebRequest;
import com.bupt.flowpackage.biz.auth.service.AdminRoleService;
import com.bupt.flowpackage.common.domain.BaseResponse;
import com.bupt.flowpackage.common.domain.SessionVo;
import com.bupt.flowpackage.common.exception.ExceptionHelper;
import com.bupt.flowpackage.common.session.SessionUtil;

@Controller
@RequestMapping("/")
public class WebLoginController {
	public static Logger logger = LoggerFactory.getLogger(WebLoginController.class);
	private static final String INDEX_PAGE ="home";
	private static final String LOGIN_PAGE ="login";
	
	@Resource
	private AdminRoleService adminRoleService;
	
	@ResponseBody
	@RequestMapping("/login")
	public BaseResponse<String> login(UserLoginWebRequest req, HttpServletRequest request) {
		BaseResponse<String> baseResp = new BaseResponse<String>();
		try{
			SessionVo sessionVo = adminRoleService.checkLoginUserAndPwdService(req);
			SessionUtil.login(sessionVo);
		}catch(Exception e) {
			baseResp = ExceptionHelper.createResponse(e, req);
		}finally{
			logger.info("\nreuqestNo={} login 返回对象resp=[{}]", req.getRequestNo(), baseResp);
		}
		return baseResp;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		try{
			SessionUtil.logout();
		}catch(Exception e) {
			logger.error("退出失败", e);
		}
		return LOGIN_PAGE;
	}
	
	@RequestMapping("/tologin")
	public String tologin() {
		return LOGIN_PAGE;
	}
	
	@RequestMapping("/index")
	public String index() {
		return INDEX_PAGE;
	}
}
