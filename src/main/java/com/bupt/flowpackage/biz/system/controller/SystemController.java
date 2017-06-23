package com.bupt.flowpackage.biz.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
* @Description:系统模块
* @author wangdaojian
* @company 摩尔科技有限公司版权所有
* @date 2017年6月23日 下午3:19:56
 */
@Controller
@RequestMapping("/system")
public class SystemController {
	
	/**
	 * <p>系统日志</p>   
	 * @param @param request
	 * @param @return      
	 * @return String
	 */
	@RequestMapping("/system-log")
	public String adminPermission() {
		return "system/system-log";
	}
}
