package com.bupt.flowpackage.mybatis.account.adminrole.mapper;

import com.bupt.flowpackage.common.annotation.MyBatisRepository;
import com.bupt.flowpackage.mybatis.account.adminrole.model.AdminRole;
@MyBatisRepository
public interface AdminRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminRole record);

    int insertSelective(AdminRole record);
    
    int deleteSelective(AdminRole record);

    AdminRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminRole record);
    
    int updateRoleByAdminId(AdminRole record);

    int updateByPrimaryKey(AdminRole record);
}