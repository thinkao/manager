package com.wxy.service.impl;

import com.wxy.dao.Admin_coursetableDao;
import com.wxy.pojo.Admin_coursetable;
import com.wxy.service.Admin_coursetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Admin_coursetableServiceImpl implements Admin_coursetableService {

    @Autowired
    private Admin_coursetableDao admin_coursetableDao;
    @Override
    public List<Admin_coursetable> getCourseTableAll() {
        return admin_coursetableDao.getCourseTableAll();
    }

    @Override
    public List<Admin_coursetable> getCourseByCno(Integer cno) {
        return admin_coursetableDao.getCourseByCno(cno);
    }
}
