package com.wxy.service.base;

import com.wxy.dao.Student_menusDao;
import com.wxy.pojo.Student_menus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Student_menusService {

    @Autowired
    private Student_menusDao student_menusDao;

    public List<Student_menus> getMenusAll(){
        return student_menusDao.selectByCondition();
    }
}
