package com.wxy.controller;

import com.wxy.pojo.*;
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
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private Admin_noticeService admin_noticeService;

    @Autowired
    private Admin_courseService admin_courseService;

    @Autowired
    private Admin_coursetableService admin_coursetableService;

    @Autowired
    private Admin_roomService admin_roomService;

    @Autowired
    private Student_noticeService student_noticeService;

    @Autowired
    private Teacher_noticeService teacher_noticeService;


    /******************************学生管理************************************/
    @RequestMapping(value = "/stu" ,method = RequestMethod.GET)
    public String studentManager(Integer sno,Model model){
        List<Student> studentList = studentService.getStudentAll();
        model.addAttribute("studentList",studentList);
        return "admin_studentManagerInfo";
    }
    @RequestMapping(value = "/updateStudent/{sno}",method = RequestMethod.GET)
    public String updateStudent(@PathVariable Integer sno, Model model, HttpSession session){
        Student student = studentService.getStudentBySno(sno);
        model.addAttribute("student",student);
        System.out.println("进入到方法");
        return "admin_updateStudentInfo";
    }
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String update(Student student,Model model){
        studentService.updateStudent(student);
        return "redirect:/admin/stu";
    }
    @RequestMapping(value = "/delete/{sno}",method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable("sno") Integer sno){
        studentService.deleteStudent(sno);
        return "redirect:/admin/stu";
    }
    @RequestMapping(value = "/addStudent",method = RequestMethod.GET)
    public String addStudent(){
        return "admin_addStudentInfo";
    }
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Student student){
        studentService.addStudent(student);
        return "redirect:/admin/stu";
    }
    /******************************教师管理************************************/
    @RequestMapping(value = "/tea" ,method = RequestMethod.GET)
    public String teacherManager(Integer tno,Model model){
        List<Teacher> teacherList = teacherService.getTeacherAll();
        model.addAttribute("teacherList",teacherList);
        return "admin_teacherManagerInfo";
    }
    @RequestMapping(value = "/updateTeacher/{tno}",method = RequestMethod.GET)
    public String updateTeacher(@PathVariable Integer tno, Model model, HttpSession session){
        Teacher teacher = teacherService.getTeacherByTno(tno);
        model.addAttribute("teacher",teacher);
        System.out.println("进入到方法");
        return "admin_updateTeacherInfo";
    }
    @RequestMapping(value = "/updateTea",method = RequestMethod.GET)
    public String updateTeacher(Teacher teacher,Model model){
        System.out.println(teacher);
        teacherService.updateTeacher(teacher);
        System.out.println(teacher);
        return "redirect:/admin/tea";
    }
    @RequestMapping(value = "/deleteTeacher/{tno}",method = RequestMethod.DELETE)
    public String deleteTeacher(@PathVariable("tno") Integer tno){
        teacherService.deleteTeacher(tno);
        return "redirect:/admin/tea";
    }
    @RequestMapping(value = "/addTeacher",method = RequestMethod.GET)
    public String addTeacher(){
        return "admin_addTeacherInfo";
    }
    @RequestMapping(value = "/addTea",method = RequestMethod.GET)
    public String add(Teacher teacher){
        teacherService.addTeacher(teacher);
        return "redirect:/admin/tea";
    }
    /******************************公告管理************************************/

    @RequestMapping(value = "/notice",method = RequestMethod.GET)
    public String noticeShow(Model model){
        List<Admin_notice> admin_noticeList = admin_noticeService.getNoticeAll();
        System.out.println(admin_noticeList);
        model.addAttribute("admin_noticeList",admin_noticeList);
        return "admin_noticeInfo";
    }
    @RequestMapping(value = "/putNotice",method = RequestMethod.GET)
    public String putNotice(){
        return "admin_putNotice";
    }
    @RequestMapping(value = "/putOver",method = RequestMethod.GET)
    public String putOver(Admin_notice admin_notice){
        admin_noticeService.addNoticeAll(admin_notice);
        teacher_noticeService.addTeacherNotice(admin_notice);
        student_noticeService.addStudentNotice(admin_notice);
        return "redirect:/admin/notice";
    }
    /******************************课程管理************************************/
    @RequestMapping("/course")
    public String showCourse(Model model){
        List<Admin_course> admin_courseList = admin_courseService.getCourseAll();
        model.addAttribute("admin_courseList",admin_courseList);
        return "admin_courseInfo";
    }
    @RequestMapping(value = "/deleteCourse/{cno}",method = RequestMethod.DELETE)
    public String deleteCourse(@PathVariable Integer cno){
        admin_courseService.deleteCourse(cno);
        return "redirect:/admin/course";
    }
    @RequestMapping(value = "/updateCourse/{cno}",method = RequestMethod.GET)
    public String updateCourse(@PathVariable Integer cno,Model model){
        Admin_course admin_course = admin_courseService.getCourseByCno(cno);
        model.addAttribute("admin_course",admin_course);
        return "admin_updateCourseInfo";
    }
    @RequestMapping(value = "/updateCour",method = RequestMethod.GET)
    public String updateCour(Admin_course admin_course){
        System.out.println(admin_course);
        admin_courseService.updateCourse(admin_course);
        System.out.println(admin_course);
        return "redirect:/admin/course";
    }
    @RequestMapping(value = "/addCourse",method = RequestMethod.GET)
    public String addCourse(){
        return "admin_addCourse";
    }
    @RequestMapping(value = "/addCour",method = RequestMethod.GET)
    public String addCour(Admin_course admin_course){
        admin_courseService.addCourse(admin_course);
        return "redirect:/admin/course";
    }
    @RequestMapping(value = "/looktable/{cno}",method = RequestMethod.GET)
    public String lookTable(@PathVariable Integer cno, Model model){
        admin_courseService.getCourseByCno(cno);
        List<Admin_coursetable> admin_coursetableList1 = admin_coursetableService.getCourseTableAll();
        System.out.println("================"+cno);
        for(int i=0;i<admin_coursetableList1.size();i++){
            System.out.println("进入到循环");
            String newcno = String.valueOf(cno);
            String admin_coursetable = admin_coursetableList1.get(i).getCno();
            System.out.println("结果"+admin_coursetable);
            if(newcno.equals(admin_coursetable)){
                System.out.println("执行if条件");
                List<Admin_coursetable> admin_coursetableList = admin_coursetableService.getCourseByCno(cno);
                System.out.println(admin_coursetableList);
                model.addAttribute("admin_coursetableList",admin_coursetableList);
            }

        }

        return "admin_coursetableInfo";
    }
    @RequestMapping(value = "/lookstudent",method = RequestMethod.GET)
    public String lookStudent(){
        return "ok";
    }
    /******************************教室管理************************************/
    @RequestMapping(value = "/room",method = RequestMethod.GET)
    public String room(Model model){
        List<Admin_room> admin_roomList = admin_roomService.getRoomAll();
        model.addAttribute("admin_roomList",admin_roomList);
        return "admin_roomInfo";
    }
    @RequestMapping(value = "/addRoom",method = RequestMethod.GET)
    public String addRoom(){
        return "admin_addRoom";
    }
    @RequestMapping(value = "/addRooms",method = RequestMethod.GET)
    public String addRooms(Admin_room admin_room){
        admin_roomService.addRoom(admin_room);
        return "redirect:/admin/room";
    }
    /******************************其他管理************************************/
    @RequestMapping(value = "/other",method = RequestMethod.GET)
    public String otherShow(){
        return "admin_otherInfo";
    }
}
