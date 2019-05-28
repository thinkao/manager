package com.wxy.dao;

import com.wxy.pojo.Student_menus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Student_menusDao {

    List<Student_menus> selectByCondition();
}
