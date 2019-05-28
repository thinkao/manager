package com.wxy.service;

import com.wxy.pojo.Admin_coursetable;

import java.util.List;

public interface Admin_coursetableService {

    List<Admin_coursetable> getCourseTableAll();

    List<Admin_coursetable> getCourseByCno(Integer cno);
}
