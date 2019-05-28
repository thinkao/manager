package com.wxy.dao;

import com.wxy.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Teacher_studentOneDao {

    List<Student> getOneTeacher_studentAll();

    void addOneTeacher_student(Student student);

    void deleteTeacher_student(Integer sno);

    void updateTeacher_Student(Student student);

    Student getOneStudentBySno(Integer sno);

}
