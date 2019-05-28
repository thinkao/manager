package com.wxy.controller;

import com.wxy.pojo.Admin_notice;
import com.wxy.pojo.Student;
import com.wxy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private Teacher_studentService teacher_studentService;

    @Autowired
    private TeacherOne_studentService teacherOne_studentService;

    @Autowired
    private Teacher_noticeService teacher_noticeService;

    @Autowired
    private Student_noticeService student_noticeService;

    /**************************我的信息*******************************/
    @RequestMapping(value = "/infor",method = RequestMethod.GET)
    public String Infor(){
        return "teacher_inforInfo";
    }
    /**************************学生管理*******************************/
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public String StudentManager(Model model, HttpSession session){
        session.getAttribute("teacherList2");
        String tno = (String) session.getAttribute("teacherList2");
        if(tno.equals("9001")){
            List<Student> teacher_studentList = teacher_studentService.getTeacher_studentAll();
            model.addAttribute("teacher_studentList",teacher_studentList);
        }else if(tno.equals("9002")){
            List<Student> teacher_studentList = teacherOne_studentService.getOneTeacher_studentAll();
            model.addAttribute("teacher_studentList",teacher_studentList);
        }

        return "teacher_studentManagerInfo";
    }
    /**************************成绩管理*******************************/
    @RequestMapping(value = "/grade",method = RequestMethod.GET)
    public String Grade(HttpSession session,Model model){
        String tno = String.valueOf(session.getAttribute("teacherList2"));
        System.out.println(tno);
        if(tno.equals("9001")){
            List<Student> studentList = teacher_studentService.getTeacher_studentAll();
            model.addAttribute("studentList",studentList);
        }else if(tno.equals("9002")){
            List<Student> studentList = teacherOne_studentService.getOneTeacher_studentAll();
            model.addAttribute("studentList",studentList);
        }

        return "teacher_studentGradeInfo";
    }
    @RequestMapping(value = "/startGrade/{sno}",method = RequestMethod.GET)
    public String startGrade(@PathVariable Integer sno,Model model,HttpSession session){
        String tno = String.valueOf(session.getAttribute("teacherList2"));
        if(tno.equals("9001")){
            Student student = teacher_studentService.getOneStudentBySno(sno);
            model.addAttribute("student",student);
        }else if(tno.equals("9002")){
            Student student = teacherOne_studentService.getOneStudentBySno(sno);
            model.addAttribute("student",student);
        }
        return "teacher_startGrade";
    }
    @RequestMapping(value = "/addGrade",method = RequestMethod.GET)
    public String addGrade(HttpSession session,Model model,Student student){
        String tno = String.valueOf(session.getAttribute("teacherList2"));
        if(tno.equals("9001")){
            teacher_studentService.updateTeacher_Student(student);
        }else if(tno.equals("9002")){
            teacherOne_studentService.updateTeacher_Student(student);
        }
        return "redirect:/teacher/grade";
    }
    /**************************公告管理*******************************/
    @RequestMapping(value = "/notice",method = RequestMethod.GET)
    public String Notice(Model model){
        List<Admin_notice> admin_noticeList = teacher_noticeService.getTeacherNoticeAll();
        model.addAttribute("admin_noticeList",admin_noticeList);
        return "teacher_noticeInfo";
    }
    @RequestMapping(value = "/putStudentNotice",method = RequestMethod.GET)
    public String putNotice(){
        return "teacher_putNotice";
    }
    @RequestMapping(value = "/putOver",method = RequestMethod.GET)
    public String putOver(Admin_notice admin_notice){
        teacher_noticeService.addTeacherNotice(admin_notice);
        student_noticeService.addStudentNotice(admin_notice);
        return "redirect:/teacher/notice";
    }
}
