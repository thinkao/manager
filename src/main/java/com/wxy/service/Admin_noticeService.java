package com.wxy.service;

import com.wxy.pojo.Admin_notice;

import java.util.List;

public interface Admin_noticeService {

    List<Admin_notice> getNoticeAll();

    void addNoticeAll(Admin_notice admin_notice);
}
