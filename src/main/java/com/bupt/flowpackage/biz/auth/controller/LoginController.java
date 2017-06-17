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
	private static final String INDEX_PAGE ="home";
	private static final String LOGIN_PAGE ="login";
	
	@ResponseBody
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView(LOGIN_PAGE);
		return mv;
	}
	
	@RequestMapping("/index")
	public String index() {
		/*ModelAndView mv = new ModelAndView(INDEX_PAGE);
		return mv;*/
		return INDEX_PAGE;
	}
}
