package com.bupt.flowpackage.biz.auth.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bupt.flowpackage.biz.auth.model.AdminVo;
import com.bupt.flowpackage.biz.auth.model.MenuVo;
import com.bupt.flowpackage.biz.auth.model.UserLoginWebRequest;
import com.bupt.flowpackage.biz.auth.model.WebLoginSuccessResp;
import com.bupt.flowpackage.biz.auth.service.AdminRoleService;
import com.bupt.flowpackage.common.domain.BaseResponse;
import com.bupt.flowpackage.common.domain.SessionVo;
import com.bupt.flowpackage.common.exception.BizException;
import com.bupt.flowpackage.mybatis.account.admin.mapper.AdminMapper;
import com.bupt.flowpackage.mybatis.account.admin.model.Admin;
import com.bupt.flowpackage.mybatis.account.admin.model.AdminRole;

/**
 * <p>Description:管理员权限角色接口服务</p>
 * <p>Company:摩尔科技</p>
 * @author daojian
 * @date 2017年6月12日 下午10:29:45
 */
@Service
public class AdminRoleServiceImpl implements AdminRoleService{
	
	@Resource
	private AdminMapper adminMapper;

	@Override
	public BaseResponse<String> checkLoginUserAndPwdService(UserLoginWebRequest req){
		Admin admin = new Admin();
		admin.setLoginName(req.getLoginName());
		int count = adminMapper.selectCountBySelective(admin);
		if(count == 0) {
			BizException.warn(101, "用户名不存在!");
		}
		admin.setPassword(req.getPassword());
		count = adminMapper.selectCountBySelective(admin);
		if(count == 0) {
			BizException.warn(102, "密码不正确，请重新输入!");
		}
		return BaseResponse.success(req);
	}
	
	public BaseResponse<WebLoginSuccessResp> loginWebSuccessService(SessionVo sessionVo) {
		
		return null;
	}
	
	private MenuVo getMenuInfoByRoleId(Integer roleId) {
		
		return null;
	}
	
	/**
	 * <p>根据管理员名获取管理员角色信息</p>   
	 * @param @param loginName
	 * @param @return      
	 * @return AdminVo
	 */
	private AdminVo getAdminRoleInfoByLoginName(String loginName) {
		Admin adminReq = new Admin();
		adminReq.setLoginName(loginName);
		AdminRole adminRole = adminMapper.selectAdminRoleInfo(adminReq);
		if(adminRole == null) {
			BizException.warn(103, "用户登录成功后，用户信息丢失!");
		}
		AdminVo adminResp = new AdminVo();
		adminResp.setAdminId(adminRole.getAdminId());
		adminResp.setLoginName(adminRole.getLoginName());
		adminResp.setRoleName(adminRole.getRoleName());
		adminResp.setRoleId(adminRole.getRoleId());
		return adminResp;
	}
}
