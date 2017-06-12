package com.bupt.flowpackage.mybatis.account.mapper;

import com.bupt.flowpackage.mybatis.account.model.AdminVo;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminVo record);

    int insertSelective(AdminVo record);

    AdminVo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AdminVo record);

    int updateByPrimaryKey(AdminVo record);
}