package com.wxy.service;

import com.wxy.pojo.Admin_notice;

import java.util.List;

public interface Teacher_noticeService {

    List<Admin_notice> getTeacherNoticeAll();

    void addTeacherNotice(Admin_notice admin_notice);
}
