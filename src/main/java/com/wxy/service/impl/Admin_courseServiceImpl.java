package com.wxy.service.impl;

import com.wxy.dao.Admin_courseDao;
import com.wxy.pojo.Admin_course;
import com.wxy.service.Admin_courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Admin_courseServiceImpl implements Admin_courseService {

    @Autowired
    private Admin_courseDao admin_courseDao;
    @Override
    public List<Admin_course> getCourseAll() {
        return admin_courseDao.getCourseAll();
    }

    @Override
    public void deleteCourse(Integer cno) {

        admin_courseDao.deleteCourse(cno);
    }

    @Override
    public void addCourse(Admin_course admin_course) {

        admin_courseDao.addCourse(admin_course);
    }

    @Override
    public void updateCourse(Admin_course admin_course) {
        admin_courseDao.updateCourse(admin_course);
    }

    @Override
    public Admin_course getCourseByCno(Integer cno) {
        return admin_courseDao.getCourseByCno(cno);
    }
}
