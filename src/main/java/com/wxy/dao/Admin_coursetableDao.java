package com.wxy.dao;

import com.wxy.pojo.Admin_coursetable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Admin_coursetableDao {

    List<Admin_coursetable> getCourseTableAll();

    List<Admin_coursetable> getCourseByCno(Integer cno);

}
