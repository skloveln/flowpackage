package com.bupt.flowpackage.biz.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/")
@Controller
public class LoginController {
	private static final String LOGIN_PAGE ="login";
	
	@ResponseBody
	@RequestMapping("/login")
	public String login() {
		return "test道建";
	}
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView(LOGIN_PAGE);
		return mv;
	}
}
