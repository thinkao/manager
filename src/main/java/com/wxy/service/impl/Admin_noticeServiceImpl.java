package com.wxy.service.impl;

import com.wxy.dao.Admin_noticeDao;
import com.wxy.pojo.Admin_notice;
import com.wxy.service.Admin_noticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Admin_noticeServiceImpl implements Admin_noticeService {
    @Autowired
    private Admin_noticeDao admin_noticeDao;
    @Override
    public List<Admin_notice> getNoticeAll() {
        return admin_noticeDao.getNoticeAll();
    }

    @Override
    public void addNoticeAll(Admin_notice admin_notice) {
        admin_noticeDao.addNoticeAll(admin_notice);
    }
}
