package com.wxy.dao;

import com.wxy.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Teacher_studentDao {

    List<Student> getTeacher_studentAll();

    void addTeacher_student(Student student);

    void deleteTeacher_student(Integer sno);

    Integer countStudent = 0;

    void updateTeacher_Student(Student student);

    Student getOneStudentBySno(Integer sno);

}
