package com.wxy.service;

import com.wxy.pojo.Admin_room;

import java.util.List;

public interface Admin_roomService {

    List<Admin_room> getRoomAll();

    void addRoom(Admin_room admin_room);
}
