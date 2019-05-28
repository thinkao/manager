package com.wxy.dao;

import com.wxy.pojo.Admin_notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Teacher_noticeDao {
    List<Admin_notice> getTeacherNoticeAll();

    void addTeacherNotice(Admin_notice admin_notice);
}
