package com.bupt.flowpackage.biz.auth.service;

import com.bupt.flowpackage.biz.auth.model.UserLoginWebRequest;
import com.bupt.flowpackage.common.domain.BaseResponse;

/**
 * <p>Description:账号角色权限接口</p>
 * <p>Company:摩尔科技</p>
 * @author daojian
 * @date 2017年6月12日 下午10:28:25
 */
public interface AdminRoleService {
	
	/**
	 * <p>校验登陆用户名密码</p>   
	 * @param @param req
	 * @param @return      
	 * @return BaseResponse<Boolean>
	 */
	public BaseResponse<Boolean> checkLoginUserAndPwd(UserLoginWebRequest req);
	
}
