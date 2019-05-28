package com.wxy.dao;

import com.wxy.pojo.Admin_notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Student_noticeDao {

    List<Admin_notice> getStudentNoticeAll();

    void addStudentNotice(Admin_notice admin_notice);
}
