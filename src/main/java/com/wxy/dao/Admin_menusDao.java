package com.wxy.dao;

import com.wxy.pojo.Admin_menus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Admin_menusDao {

    List<Admin_menus> selectByCondition();
}
