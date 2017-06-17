package com.bupt.flowpackage.biz.auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/")
@Controller
public class LoginController {
	public static Logger logger = LoggerFactory.getLogger(LoginController.class);
	private static final String LOGIN_PAGE ="home";
	
	@ResponseBody
	@RequestMapping("/login")
	public String login() {
		return "test道建";
	}
	
	@RequestMapping("/index")
	public ModelAndView index() {
		try{
			int i = 1/0;
		}catch(Exception e) {
			logger.error("访问首页失败！", e);
		}
		ModelAndView mv = new ModelAndView(LOGIN_PAGE);
		return mv;
	}
}
