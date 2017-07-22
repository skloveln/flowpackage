package com.bupt.flowpackage.mybatis.account.role.mapper;

import java.util.List;

import com.bupt.flowpackage.common.annotation.MyBatisRepository;
import com.bupt.flowpackage.mybatis.account.role.model.Role;
@MyBatisRepository
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);
    
    List<Role> selectRoleList();

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}