package com.wxy.dao;

import com.wxy.pojo.Admin_notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Admin_noticeDao {

    List<Admin_notice> getNoticeAll();

    void addNoticeAll(Admin_notice admin_notice);
}
