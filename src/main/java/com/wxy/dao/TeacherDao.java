package com.wxy.dao;

import com.wxy.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherDao {
    List<Teacher> getTeacherAll();

    Teacher getTeacherByTno(Integer tno);

    void deleteTeacher(Integer tno);

    void updateTeacher(Teacher teacher);

    void addTeacher(Teacher teacher);
}
