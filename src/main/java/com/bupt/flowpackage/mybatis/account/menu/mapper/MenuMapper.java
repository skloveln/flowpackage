package com.bupt.flowpackage.mybatis.account.menu.mapper;

import java.util.List;

import com.bupt.flowpackage.common.annotation.MyBatisRepository;
import com.bupt.flowpackage.mybatis.account.application.model.Application;
import com.bupt.flowpackage.mybatis.account.menu.model.Menu;
@MyBatisRepository
public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);
    
    List<Application> getAllMenuList(Integer roleId);

    int updateByPrimaryKey(Menu record);
}