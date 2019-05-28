package com.wxy.controller;

import com.wxy.pojo.*;
import com.wxy.service.base.Admin_menusService;
import com.wxy.service.base.Student_menusService;
import com.wxy.service.base.Teacher_menusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
public class MainController {

    @Autowired
    private Admin_menusService admin_menusService;

    @Autowired
    private Student_menusService student_menusService;

    @Autowired
    private Teacher_menusService teacher_menusService;

    @RequestMapping(value = "/admin_main",method = RequestMethod.GET)
    public String admin_main(Model model){
        System.out.println("-------管理-------");
        List<Admin_menus> admin_menusList = admin_menusService.getAllMenu();
        model.addAttribute("admin_menusList",admin_menusList);
        System.out.println(admin_menusList);
        System.out.println("-------------------管理员-----------------");
        return "admin_main";
    }
    @RequestMapping(value = "/student_main")
    public String student_main(Model model, HttpSession session){
        List<Student_menus> student_menusList = student_menusService.getMenusAll();
        model.addAttribute("student_menusList",student_menusList);
        System.out.println(student_menusList);
        //从session获取User对象
        Users users = (Users) session.getAttribute("users");
        //如果用户为空，则创建新的对象
        if (users == null) {
            users = new Users();
            users.setUid(UUID.randomUUID().toString());
            //设置默认头像
            String avatar = "/E/D/auto.jpg";
            users.setAvatar(avatar);
            session.setAttribute("users",users);
        }
        return "student_main";
    }
    @RequestMapping(value = "/teacher_main")
    public String teacher_main(Model model,HttpSession session){
        List<Teacher_menus> teacher_menusList = teacher_menusService.getMenusAll();
        model.addAttribute("teacher_menusList",teacher_menusList);
        //从session获取User对象
        Users users = (Users) session.getAttribute("users");
        //如果用户为空，则创建新的对象
        if (users == null) {
            users = new Users();
            users.setUid(UUID.randomUUID().toString());
            //设置默认头像
            String avatar = "/E/D/auto.jpg";
            users.setAvatar(avatar);
            session.setAttribute("users",users);
        }
        return "teacher_main";
    }
}
