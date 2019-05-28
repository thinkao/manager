package com.wxy.dao;

import com.wxy.pojo.Teacher_menus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Teacher_menusDao {
    List<Teacher_menus> selectByCondition();
}
