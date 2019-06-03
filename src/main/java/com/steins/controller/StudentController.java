package com.steins.controller;

import com.steins.entity.*;
import com.steins.service.impl.BJService;
import com.steins.service.impl.StudentService;
import com.steins.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Sunny
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
//    @Autowired
//    private BJService bjService;
    Students students=new Students();

    @RequestMapping("/login")
    public String login(HttpSession session, HttpServletRequest request, @RequestParam("sid")Integer sid, @RequestParam("password")String password){
        students.setSid(sid);
        students.setPassword(password);
        Students existStudent = studentService.login(students);
        //判断用户是否存在
        if(existStudent == null){
            return "sdenglu";
        }else{
            session.setAttribute("existStudent", existStudent);
            return "/student/welcome";
        }

    }

// 修改密码
    @RequestMapping("/update")
    public String teacherUpdate(HttpServletRequest request,HttpSession session,@RequestParam("npw")String npw){
        Students students= (Students) session.getAttribute("existStudent");
        studentService.updatePW(students.getSid(),npw);
        return "/teacher/upwsuccess";
    }
//    安全退出清除session
    @RequestMapping("/sessionDestory")
    public  String sessionDestory(HttpSession session){
        session.invalidate();
        return "sdenglu";
    }

//  教师查看学生
    @RequestMapping("/ckAllStudent")
    public String ckAllStudent(HttpServletRequest request,HttpSession session,@RequestParam("page")Integer page){

        Teacher teacher= (Teacher) session.getAttribute("existTeacher");
        PageBean<Students> studentsPageBean=studentService.ckStudent(teacher.getTid(),page);
        request.setAttribute("studentsPageBean",studentsPageBean);
        return "/teacher/ckallstudent";

    }


//  管理员查看学生
    @RequestMapping("/ckAllStudentAdmin")
    public String ckAllStudentAdmin(HttpServletRequest request,HttpSession session,@RequestParam("page")Integer page){

        PageBean<Students> studentsPageBean=studentService.ckStudentAdmin(page);
        request.setAttribute("studentsPageBean",studentsPageBean);
        return "/admin/ckallstudent";

    }
    //根据学号删除学生信息
    @RequestMapping("/deleteStudent")
    public String deleteStudent(HttpServletRequest request,HttpSession session,@RequestParam("page")Integer page,@RequestParam("sid")Integer sid){
        Teacher teacher= (Teacher) session.getAttribute("existTeacher");
        studentService.deleteStudent(sid);
        PageBean<Students> pageBean = studentService.ckStudent(teacher.getTid(),page);
        //将PageBean存入值栈中
        session.setAttribute("pageBean", pageBean);
        return "redirect:/students/ckAllStudent";
    }
    //管理员根据学号删除学生信息
    @RequestMapping("/deleteStudentAdmin")
    public String deleteStudentAdmin(HttpServletRequest request,HttpSession session,@RequestParam("page")Integer page,@RequestParam("sid")Integer sid){
        studentService.deleteStudent(sid);
        PageBean<Students> pageBean = studentService.ckStudentAdmin(page);
        //将PageBean存入值栈中
        session.setAttribute("pageBean", pageBean);
        return "redirect:/students/ckAllStudentAdmin";
    }
////    管理员添加学生信息
//    @RequestMapping("/addStudentAdmin")
//    public  String addStudentAdmin(HttpServletRequest request,@RequestParam("tid")Integer tid,@RequestParam("sid")Integer sid,@RequestParam("password")String password,@RequestParam("phone")String phone,@RequestParam("bjid")Integer bjid){
//        Students students=new Students();
//        students.setSid(sid);
//        students.setPassword(password);
//        students.setPhone(phone);
////        BJ bj=new BJ();
////        Integer bjid=bjService.
//        studentService.addStudentSX(students,bjid);
//        List<BJ> list =studentService.ckbjAdmin();
//        request.setAttribute("listbj",list);
//        return "/admin/addstudent" ;
//    }
//    管理员添加学生信息
    @RequestMapping("/addStudentAdmin")
    public  String addStudent(HttpServletRequest request,@RequestParam("tid")Integer tid,@RequestParam("sid")Integer sid,@RequestParam("password")String password,@RequestParam("phone")String phone,@RequestParam("bjid")Integer bjid){
        Students students=new Students();
        students.setSid(sid);
        students.setPassword(password);
        students.setPhone(phone);
//        BJ bj=new BJ();
//        Integer bjid=bjService.
        studentService.addStudentSX(students,bjid);
        List<BJ> list = studentService.ckbj(tid);
        request.setAttribute("listbj",list);
        return "/teacher/addstudent" ;
    }

//   学生信息完善
    @RequestMapping("/wsStudent")
    public String wsStudent(HttpServletRequest request,@RequestParam("sid")Integer sid){
        Students student = studentService.cxStudent(sid);
        request.setAttribute("student",student);

        return "/student/wsstudent";
    }
//    完善学生信息实现
    @RequestMapping("/wsStudentSX")
    public String wsStudentSX(HttpServletRequest request,@RequestParam("sid")Integer sid,@RequestParam("phone")String phone,@RequestParam("name")String name,@RequestParam("email")String email){
        Students student=new Students();
        student.setSid(sid);
        student.setPhone(phone);
        student.setEmail(email);
        student.setName(name);
        studentService.wsStudentSX(student);
        return "/teacher/addqsuccess";
    }
//    查看学生考试记录
    @RequestMapping("/ckTestNote")
    public String ckTestNote(HttpServletRequest request,@RequestParam("sid")Integer sid){
        List<TestNote> testNotes = studentService.ckTestNote(sid);
        request.setAttribute("testNotes", testNotes);
        return "/teachercktestnote";
    }
//    查看试卷信息
    @RequestMapping("/ckAnswerState")
    public String ckAnswerState(HttpServletRequest request,@RequestParam("tnid")Integer tnid){
            //查看选择题
            List<AnswerState> answerStatesxz = studentService.ckAnswerStatexz(tnid);
            //查看判断题
            List<AnswerState> answerStatespd = studentService.ckAnswerStatepd(tnid);
            //查看填空题
            List<AnswerState> answerStatestk = studentService.ckAnswerStatetk(tnid);
            request.setAttribute("answerStatesxz", answerStatesxz);
            request.setAttribute("answerStatespd", answerStatespd);
            request.setAttribute("answerStatestk", answerStatestk);
            return "/teacher/ckanserstate";
    }
//    我的班级
    @RequestMapping("/myBJ")
    public String myBJ(HttpServletRequest request,@RequestParam("sid") Integer sid){
        BJ bj=new BJ();
        bj=studentService.myBJ(sid);
        request.setAttribute("bj",bj);
        return "/student/mybj";
    }
//    查看学生信息
    @RequestMapping("/ckStudentXX")
    public String ckStudentXX(HttpServletRequest request,@RequestParam("sid")Integer sid){
        Students students=new Students();
        students=studentService.ckStudentXX(sid);
        request.setAttribute("students",students);
        return "/admin/ckstudentxx";
    }


}
