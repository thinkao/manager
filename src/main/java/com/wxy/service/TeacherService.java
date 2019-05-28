package com.wxy.service;

import com.wxy.pojo.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getTeacherAll();

    Teacher getTeacherByTno(Integer tno);

    void deleteTeacher(Integer tno);

    void updateTeacher(Teacher teacher);

    void addTeacher(Teacher teacher);
}
