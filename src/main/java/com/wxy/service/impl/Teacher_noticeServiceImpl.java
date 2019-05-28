package com.wxy.service.impl;

import com.wxy.dao.Teacher_noticeDao;
import com.wxy.pojo.Admin_notice;
import com.wxy.service.Teacher_noticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Teacher_noticeServiceImpl implements Teacher_noticeService {

    @Autowired
    private Teacher_noticeDao teacher_noticeDao;
    @Override
    public List<Admin_notice> getTeacherNoticeAll() {
        return teacher_noticeDao.getTeacherNoticeAll();
    }

    @Override
    public void addTeacherNotice(Admin_notice admin_notice) {
        teacher_noticeDao.addTeacherNotice(admin_notice);
    }
}
