package com.wxy.service.impl;

import com.wxy.dao.Student_noticeDao;
import com.wxy.dao.Teacher_noticeDao;
import com.wxy.pojo.Admin_notice;
import com.wxy.service.Student_noticeService;
import com.wxy.service.Teacher_noticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Student_noticeServiceImpl implements Student_noticeService {

    @Autowired
    private Student_noticeDao student_noticeDao;

    @Override
    public List<Admin_notice> getStudentNoticeAll() {
        return student_noticeDao.getStudentNoticeAll();
    }

    @Override
    public void addStudentNotice(Admin_notice admin_notice) {
        student_noticeDao.addStudentNotice(admin_notice);
    }
}

