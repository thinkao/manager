package com.wxy.service.impl;

import com.wxy.dao.Admin_roomDao;
import com.wxy.pojo.Admin_room;
import com.wxy.service.Admin_roomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Admin_roomServiceImpl implements Admin_roomService {

    @Autowired
    private Admin_roomDao admin_roomDao;

    @Override
    public List<Admin_room> getRoomAll() {
        return admin_roomDao.getRoomAll();
    }

    @Override
    public void addRoom(Admin_room admin_room) {
        admin_roomDao.addRoom(admin_room);
    }
}
