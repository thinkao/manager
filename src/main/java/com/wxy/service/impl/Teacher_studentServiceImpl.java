package com.wxy.service.impl;

import com.wxy.dao.Teacher_studentDao;
import com.wxy.pojo.Student;
import com.wxy.service.Teacher_studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Teacher_studentServiceImpl implements Teacher_studentService {

    @Autowired
    private Teacher_studentDao teacher_studentDao;
    @Override
    public List<Student> getTeacher_studentAll() {
        return teacher_studentDao.getTeacher_studentAll();
    }

    @Override
    public void addTeacher_student(Student student) {

        teacher_studentDao.addTeacher_student(student);
    }

    @Override
    public void deleteTeacher_student(Integer sno) {
        teacher_studentDao.deleteTeacher_student(sno);
    }

    @Override
    public void updateTeacher_Student(Student student) {
        teacher_studentDao.updateTeacher_Student(student);
    }

    @Override
    public Student getOneStudentBySno(Integer sno) {
        return teacher_studentDao.getOneStudentBySno(sno);
    }
}
