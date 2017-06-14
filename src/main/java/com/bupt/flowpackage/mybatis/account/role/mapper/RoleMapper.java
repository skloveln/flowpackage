package com.bupt.flowpackage.mybatis.account.role.mapper;

import com.bupt.flowpackage.annotation.MyBatisRepository;
import com.bupt.flowpackage.mybatis.account.role.model.Role;
@MyBatisRepository
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}