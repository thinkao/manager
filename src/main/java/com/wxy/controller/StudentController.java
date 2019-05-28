package com.wxy.controller;

import com.wxy.pojo.*;
import com.wxy.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private Admin_courseService admin_courseService;

    @Autowired
    private Teacher_studentService teacher_studentService;

    @Autowired
    private TeacherOne_studentService teacherOne_studentService;

    @Autowired
    private StudentTestService studentTestService;

    @Autowired
    private Admin_coursetableService admin_coursetableService;

    @Autowired
    private Student_noticeService student_noticeService;



    /*******************************我的信息************************************/
    @RequestMapping(value = "/infor",method = RequestMethod.GET)
    public String showInfo(Model model, HttpSession session) {

        //从session获取User对象
        Users users = (Users) session.getAttribute("users");
        //如果用户为空，则创建新的对象
        if (users == null) {
            users = new Users();
            users.setUid(UUID.randomUUID().toString());
            //设置默认头像
            String avatar = "/E/D/auto.jpg";
            users.setAvatar(avatar);
            session.setAttribute("users", users);
        }
        System.out.println("============success==========");
        return "student_inforInfo";
    }
    @GetMapping("/userInfo")
    public String userInfo(HttpSession session) {

        //从session获取User对象
        Users users = (Users) session.getAttribute("users");
        //如果用户为空，则创建新的对象
        if (users == null) {
            users = new Users();
            users.setUid(UUID.randomUUID().toString());
            //设置默认头像
            String avatar = "/home/ubuntu/uploadfiles/E/D/auto.jpg";
            users.setAvatar(avatar);
            session.setAttribute("users", users);
        }
        System.out.println("************success************");
        return "alterheadinfo";
    }
    /*******************************我要选课************************************/
    @RequestMapping(value = "/choose",method = RequestMethod.GET)
    public String chooseCourse(Model model){
        List<Admin_course> admin_courseList = admin_courseService.getCourseAll();
        model.addAttribute("admin_courseList",admin_courseList);
        return "student_chooseCourseInfo";
    }
    @RequestMapping(value = "/chooseCourse/{cno}",method = RequestMethod.GET)
    public String chooseCourse(@PathVariable Integer cno,Student student,HttpSession session,Admin_course admin_course){
        System.out.println(cno);
        /*判断是否还能选课*/
        List<Student> studentList = teacher_studentService.getTeacher_studentAll();
        int size = studentList.size();
        System.out.println(size);
        /*判断是否还能选课*/


        /*判断是否有课程冲突*/
        List<Admin_coursetable> admin_coursetableList1 = admin_coursetableService.getCourseByCno(cno);/*新加入的*/
        List<Admin_course> studentList1 = studentTestService.getStudentTestAll();/*里面原来有的*/

        System.out.println("新加入"+admin_coursetableList1);
        System.out.println("原有的"+studentList1);

        int i,j;
        for(i=0;i<admin_coursetableList1.size();i++){
            admin_coursetableList1.get(i).getTtime();
            for(j=0;j<studentList1.size();j++){
                String cno3 = studentList1.get(j).getCno();
                int cno2 = Integer.valueOf(cno3);
                List<Admin_coursetable> studentList2 = admin_coursetableService.getCourseByCno(cno2);
                studentList2.get(j).getTtime();
                if(admin_coursetableList1.get(i).getTtime().equals(studentList2.get(j).getTtime())){
                    return "ok1";
                }
            }
        }


        /*判断是否有课程冲突*/


        if(size<109){
            /*我的课表*/
            Admin_course admin_course1 = studentTestService.getCourseByCno(cno);
            System.out.println("****************"+admin_course1);
            admin_course.setCno(admin_course1.getCno());
            admin_course.setCname(admin_course1.getCname());
            admin_course.setCteacher(admin_course1.getCteacher());
            admin_course.setCnumber(admin_course1.getCnumber());
            admin_course.setCoursetab(admin_course1.getCoursetab());
            studentTestService.addStudentTest(admin_course);
            System.out.println("插入成功");
            /*我的课表*/


            String cno1 = String.valueOf(cno);
            session.setAttribute("cno1",cno1);
            session.getAttribute("student");
            System.out.println(session.getAttribute("student"));
            student.setSno((String) session.getAttribute("sno"));
            student.setSname((String) session.getAttribute("studentList1"));
            student.setSclass((String) session.getAttribute("sclass"));
            student.setSsex((String) session.getAttribute("ssex"));
            /*此处需要根据cno来判断将学生的信息插入到哪个老师的信息库中*/
            if(cno1.equals("602")){
                teacher_studentService.addTeacher_student(student);
            }else if(cno1.equals("603")){
                teacherOne_studentService.addOneTeacher_student(student);
            }
            return "ok";
        }else {
            return "ok1";
        }

    }
    @RequestMapping(value = "/nochoose/{cno}",method = RequestMethod.GET)
    public String noChoose(@PathVariable Integer cno,HttpSession session){
        session.getAttribute("sno");
        String sno1 = String.valueOf(session.getAttribute("sno"));
        int sno2 = Integer.valueOf(sno1);
        System.out.println(sno2);
        System.out.println(cno);
        String cno1 = String.valueOf(cno);
        if(cno1.equals("602")){
            teacher_studentService.deleteTeacher_student(sno2);
        }else if(cno1.equals("603")){
            teacherOne_studentService.deleteTeacher_student(sno2);
        }
        studentTestService.deleteStudentTest(cno);
        /*此处为取消选课操作*/
        return "ok";
    }
    /*******************************我的课表************************************/
    @RequestMapping(value = "/coursetable",method = RequestMethod.GET)
    public String courseTable(Model model,HttpSession session){
        List<Admin_course> admin_courseList = studentTestService.getStudentTestAll();
        System.out.println("获取到的值为"+admin_courseList);
        model.addAttribute("admin_courseList",admin_courseList);
        return "student_coursetable";
    }

    /*******************************我的成绩************************************/
    @RequestMapping(value = "/grade",method = RequestMethod.GET)
    public String Grade(HttpSession session,Model model){
        String sno = (String) session.getAttribute("sno");
        Integer sno1 = Integer.valueOf(sno);
        Student student = teacher_studentService.getOneStudentBySno(sno1);
        Student student1 = teacherOne_studentService.getOneStudentBySno(sno1);
        model.addAttribute("student",student);
        model.addAttribute("student1",student1);
        return "student_gradeInfo";
    }


    /*******************************公告管理***********************************/
    @RequestMapping(value = "/notice",method = RequestMethod.GET)
    public String notice(Model model){
        List<Admin_notice> admin_noticeList = student_noticeService.getStudentNoticeAll();
        model.addAttribute("admin_noticeList",admin_noticeList);
        return "student_noticeInfo";
    }
}
