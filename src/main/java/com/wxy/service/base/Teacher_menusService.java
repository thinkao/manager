package com.wxy.service.base;

import com.wxy.dao.Teacher_menusDao;
import com.wxy.pojo.Teacher_menus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Teacher_menusService {
    @Autowired
    private Teacher_menusDao teacher_menusDao;

    public List<Teacher_menus> getMenusAll(){
        return teacher_menusDao.selectByCondition();
    }
}
