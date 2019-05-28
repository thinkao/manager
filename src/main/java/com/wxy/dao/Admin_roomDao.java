package com.wxy.dao;

import com.wxy.pojo.Admin_room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Admin_roomDao {

    List<Admin_room> getRoomAll();

    void addRoom(Admin_room admin_room);

}
