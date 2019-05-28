package com.wxy.service;

import com.wxy.pojo.Admin_course;

import java.util.List;

public interface Admin_courseService {

    List<Admin_course> getCourseAll();

    void deleteCourse(Integer cno);

    void addCourse(Admin_course admin_course);

    void updateCourse(Admin_course admin_course);

    Admin_course getCourseByCno(Integer cno);
}
