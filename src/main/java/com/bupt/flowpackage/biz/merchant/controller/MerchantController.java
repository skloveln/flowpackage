package com.bupt.flowpackage.biz.merchant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MerchantController {
	/**
	 * <p>商户列表</p>   
	 * @param @return      
	 * @return String
	 */
	@RequestMapping("/merchant-list")
	public String merchantList() {
		return "merchant/merchant-list";
	}
	
	/**
	 * <p>订单列表</p>   
	 * @param @return      
	 * @return String
	 */
	@RequestMapping("/order-list")
	public String orderList() {
		return "merchant/order-list";
	}
	
	
}
