package com.wxy.service.impl;

import com.wxy.dao.Teacher_studentOneDao;
import com.wxy.pojo.Student;
import com.wxy.service.TeacherOne_studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Teacher_studentOneServiceImpl implements TeacherOne_studentService {

    @Autowired
    private Teacher_studentOneDao teacher_studentOneDao;
    @Override
    public List<Student> getOneTeacher_studentAll() {
        return teacher_studentOneDao.getOneTeacher_studentAll();
    }

    @Override
    public void addOneTeacher_student(Student student) {
        teacher_studentOneDao.addOneTeacher_student(student);
    }

    @Override
    public void deleteTeacher_student(Integer sno) {
        teacher_studentOneDao.deleteTeacher_student(sno);
    }

    @Override
    public void updateTeacher_Student(Student student) {
        teacher_studentOneDao.updateTeacher_Student(student);
    }

    @Override
    public Student getOneStudentBySno(Integer sno) {
        return teacher_studentOneDao.getOneStudentBySno(sno);
    }
}
