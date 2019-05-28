package com.wxy.controller;

import com.wxy.pojo.Admin_menus;
import com.wxy.pojo.Student;
import com.wxy.pojo.Teacher;
import com.wxy.service.StudentService;
import com.wxy.service.TeacherService;
import com.wxy.service.base.Admin_menusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private Admin_menusService admin_menusService;

    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "user")String user,@RequestParam(value = "pass")String pass,
                        Model model, HttpSession session,HttpServletRequest request){
        System.out.println(user);
        System.out.println(pass);
        List<Student> studentList = studentService.getStudentAll();
        List<Teacher> teacherList = teacherService.getTeacherAll();
        System.out.println(studentList);
        System.out.println(teacherList);

        if(user.equals("admin")&&pass.equals("201314")){
            System.out.println("****************************管理员************************");
            List<Admin_menus> admin_menusList = admin_menusService.getAllMenu();
            model.addAttribute("admin_menusList",admin_menusList);
            return "admin_main";
        }else {
            for(int i=0;i<studentList.size();i++){
                if(studentList.get(i).getSusername().equals(user)&&studentList.get(i).getSpassword().equals(pass)){
                    Student student = studentService.getStudentAll().get(i);
                    session.setAttribute("student",student);
                    String studentList1 = studentService.getStudentAll().get(i).getSname();

                    /*此处目的是为了获得选课人的信息*/
                    String sno = studentService.getStudentAll().get(i).getSno();
                    String sclass = studentService.getStudentAll().get(i).getSclass();
                    String ssex = studentService.getStudentAll().get(i).getSsex();
                    session.setAttribute("ssex",ssex);
                    session.setAttribute("sclass",sclass);
                    session.setAttribute("sno",sno);


                    session.setAttribute("studentList1",studentList1);
                    session.setAttribute("user",user);
                    return "redirect:/student_main";
                }
            }
            for(int j=0;j<teacherList.size();j++){
                if(teacherList.get(j).getTusername().equals(user)&&teacherList.get(j).getTpassword().equals(pass)){
                    Teacher teacher = teacherService.getTeacherAll().get(j);
                    session.setAttribute("teacher",teacher);
                    String teacherList1 = teacherService.getTeacherAll().get(j).getTname();
                    String teacherList2 = teacherService.getTeacherAll().get(j).getTno();
                    session.setAttribute("teacherList1",teacherList1);
                    session.setAttribute("teacherList2",teacherList2);
                    return "redirect:/teacher_main";
                }
            }
        }

        model.addAttribute("msg","用户名或者密码输入错误");
        return "login";
    }
    @RequestMapping("/start")
    public String launcher(){
        return "login";
    }
    @RequestMapping("/")
    public String index(){
        return "launcher";
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public String addUser(Model model){
        model.addAttribute("msg","字段不能为空");
        return "register";
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(Model model,Student student){
        studentService.addStudent(student);
        return "login";
    }
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.removeAttribute("sno");
        session.removeAttribute("studentList1");
        session.removeAttribute("ssex");
        session.removeAttribute("user");
        session.removeAttribute("pass");
        session.removeAttribute("sclass");
        session.removeAttribute("teacherList1");
        session.removeAttribute("teacherList2");
        return "login";
    }
}
