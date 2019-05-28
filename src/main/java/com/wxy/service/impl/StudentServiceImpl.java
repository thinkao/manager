package com.wxy.service.impl;

import com.wxy.dao.StudentDao;
import com.wxy.pojo.Student;
import com.wxy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getStudentAll() {
        return studentDao.getStudentAll();
    }

    @Override
    public Student getStudentBySno(Integer sno) {
        return studentDao.getStudentBySno(sno);
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);

    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);

    }

    @Override
    public void updateStudent(Integer sno) {
        studentDao.updateStudent(sno);
    }

    @Override
    public void deleteStudent(Integer sno) {
        studentDao.deleteStudent(sno);

    }
}
