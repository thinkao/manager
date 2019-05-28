package com.wxy.service.base;

import com.wxy.dao.Admin_menusDao;
import com.wxy.pojo.Admin_menus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Admin_menusService {
    @Autowired
    private Admin_menusDao admin_menusDao;

    public List<Admin_menus> getAllMenu(){
        List<Admin_menus> admin_menusList = admin_menusDao.selectByCondition();
        return admin_menusList;
    }
}
