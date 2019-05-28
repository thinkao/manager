package com.wxy.dao;

import com.wxy.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentDao {
    List<Student> getStudentAll();

    Student getStudentBySno(Integer sno);

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Integer sno);

    void updateStudent(Integer sno);
}
