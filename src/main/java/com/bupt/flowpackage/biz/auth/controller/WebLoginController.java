package com.bupt.flowpackage.biz.auth.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

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
			baseResp = adminRoleService.checkLoginUserAndPwd(req);
			SessionVo sessionInfo = new SessionVo();
			sessionInfo.setLoginName(req.getLoginName());
			SessionUtil.setSessionInfo(request.getSession(), sessionInfo);
		}catch(Exception e) {
			baseResp = ExceptionHelper.createResponse(e, req);
		}
		return baseResp;
	}
	
	@RequestMapping("/tologin")
	public String tologin() {
		return LOGIN_PAGE;
	}
	
	@RequestMapping("/index")
	public String index() {
		/*ModelAndView mv = new ModelAndView(INDEX_PAGE);
		return mv;*/
		return INDEX_PAGE;
	}
}
