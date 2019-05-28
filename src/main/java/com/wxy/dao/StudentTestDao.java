package com.wxy.dao;

import com.wxy.pojo.Admin_course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentTestDao {

    List<Admin_course> getStudentTestAll();

    void addStudentTest(Admin_course admin_course);

    Admin_course getCourseByCno(Integer cno);

    void deleteStudentTest(Integer cno);
}
