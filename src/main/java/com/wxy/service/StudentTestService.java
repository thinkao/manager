package com.wxy.service;

import com.wxy.pojo.Admin_course;
import com.wxy.pojo.Admin_coursetable;

import java.util.List;

public interface StudentTestService {

    List<Admin_course> getStudentTestAll();

    void addStudentTest(Admin_course admin_course);

    Admin_course getCourseByCno(Integer cno);

    void deleteStudentTest(Integer cno);
}
