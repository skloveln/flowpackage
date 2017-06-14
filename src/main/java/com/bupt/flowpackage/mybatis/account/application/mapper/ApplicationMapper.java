package com.bupt.flowpackage.mybatis.account.application.mapper;

import com.bupt.flowpackage.annotation.MyBatisRepository;
import com.bupt.flowpackage.mybatis.account.application.model.Application;
@MyBatisRepository
public interface ApplicationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Application record);

    int insertSelective(Application record);

    Application selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Application record);

    int updateByPrimaryKey(Application record);
}