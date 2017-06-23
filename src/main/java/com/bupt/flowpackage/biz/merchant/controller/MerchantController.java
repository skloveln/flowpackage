package com.bupt.flowpackage.biz.merchant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
* @Description: 商家管理
* @author wangdaojian
* @company 摩尔科技有限公司版权所有
* @date 2017年6月23日 下午3:20:11
 */
@Controller
@RequestMapping("/merchant")
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
