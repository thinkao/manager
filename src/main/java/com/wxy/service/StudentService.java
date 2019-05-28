package com.wxy.service;

import com.wxy.pojo.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudentAll();

    Student getStudentBySno(Integer sno);

    void addStudent(Student student);

    void updateStudent(Student student);

    void updateStudent(Integer sno);

    void deleteStudent(Integer sno);
}
