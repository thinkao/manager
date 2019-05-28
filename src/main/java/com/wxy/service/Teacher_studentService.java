package com.wxy.service;

import com.wxy.pojo.Student;

import java.util.List;

public interface Teacher_studentService {

    List<Student> getTeacher_studentAll();

    void addTeacher_student(Student student);

    void deleteTeacher_student(Integer sno);

    void updateTeacher_Student(Student student);

    Student getOneStudentBySno(Integer sno);

    Integer countStudent = 0;
}
