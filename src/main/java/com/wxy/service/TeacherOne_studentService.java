package com.wxy.service;

import com.wxy.pojo.Student;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface TeacherOne_studentService {

    List<Student> getOneTeacher_studentAll();

    void addOneTeacher_student(Student student);

    void deleteTeacher_student(Integer sno);

    void updateTeacher_Student(Student student);

    Student getOneStudentBySno(Integer sno);
}
