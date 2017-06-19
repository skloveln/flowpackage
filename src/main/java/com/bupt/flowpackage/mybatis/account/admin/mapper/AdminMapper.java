package com.bupt.flowpackage.mybatis.account.admin.mapper;

import com.bupt.flowpackage.common.annotation.MyBatisRepository;
import com.bupt.flowpackage.mybatis.account.admin.model.Admin;
@MyBatisRepository
public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);
    
    Admin selectBySelective(Admin admin);
    
    int selectCountBySelective(Admin admin);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}