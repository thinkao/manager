package com.wxy.service;

import com.wxy.pojo.Admin_notice;

import java.util.List;

public interface Student_noticeService {

    List<Admin_notice> getStudentNoticeAll();

    void addStudentNotice(Admin_notice admin_notice);
}
