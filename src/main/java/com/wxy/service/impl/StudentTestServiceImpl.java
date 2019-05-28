package com.wxy.service.impl;

import com.wxy.dao.StudentTestDao;
import com.wxy.pojo.Admin_course;
import com.wxy.pojo.Admin_coursetable;
import com.wxy.service.StudentTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentTestServiceImpl implements StudentTestService {

    @Autowired
    private StudentTestDao studentTestDao;

    @Override
    public List<Admin_course> getStudentTestAll() {
        return studentTestDao.getStudentTestAll();
    }

    @Override
    public void addStudentTest(Admin_course admin_course) {
        studentTestDao.addStudentTest(admin_course);
    }

    @Override
    public Admin_course getCourseByCno(Integer cno) {
        return studentTestDao.getCourseByCno(cno);
    }

    @Override
    public void deleteStudentTest(Integer cno) {
        studentTestDao.deleteStudentTest(cno);
    }


}
