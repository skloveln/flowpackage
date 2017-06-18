package com.bupt.flowpackage.biz.auth.service.impl;

import org.springframework.stereotype.Service;

import com.bupt.flowpackage.biz.auth.model.UserLoginWebRequest;
import com.bupt.flowpackage.biz.auth.service.AdminRoleService;
import com.bupt.flowpackage.common.domain.BaseResponse;

/**
 * <p>Description:管理员权限角色接口服务</p>
 * <p>Company:摩尔科技</p>
 * @author daojian
 * @date 2017年6月12日 下午10:29:45
 */
@Service
public class AdminRoleServiceImpl implements AdminRoleService{

	@Override
	public BaseResponse<Boolean> checkLoginUserAndPwd(UserLoginWebRequest req){
		
		return null;
	}
	
	
}
