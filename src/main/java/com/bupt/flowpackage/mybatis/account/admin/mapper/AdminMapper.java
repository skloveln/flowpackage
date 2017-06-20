package com.bupt.flowpackage.mybatis.account.admin.mapper;

import com.bupt.flowpackage.common.annotation.MyBatisRepository;
import com.bupt.flowpackage.mybatis.account.admin.model.Admin;
import com.bupt.flowpackage.mybatis.account.admin.model.AdminRole;
@MyBatisRepository
public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);
    
    Admin selectBySelective(Admin admin);
    /**
     * <p>获取管理员角色信息</p>   
     * @param @param admin
     * @param @return      
     * @return AdminRole
     */
    AdminRole selectAdminRoleInfo(Admin admin);
    
    int selectCountBySelective(Admin admin);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}