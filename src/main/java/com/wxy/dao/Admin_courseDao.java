package com.wxy.dao;

import com.wxy.pojo.Admin_course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Admin_courseDao {

    List<Admin_course> getCourseAll();

    void deleteCourse(Integer cno);

    void addCourse(Admin_course admin_course);

    void updateCourse(Admin_course admin_course);

    Admin_course getCourseByCno(Integer cno);
}
