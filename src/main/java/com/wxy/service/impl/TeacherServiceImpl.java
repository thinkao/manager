package com.wxy.service.impl;

import com.wxy.dao.TeacherDao;
import com.wxy.pojo.Teacher;
import com.wxy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Teacher> getTeacherAll() {
        return teacherDao.getTeacherAll();
    }

    @Override
    public Teacher getTeacherByTno(Integer tno) {
        return teacherDao.getTeacherByTno(tno);
    }

    @Override
    public void deleteTeacher(Integer tno) {
        teacherDao.deleteTeacher(tno);

    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherDao.updateTeacher(teacher);
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherDao.addTeacher(teacher);
    }
}
