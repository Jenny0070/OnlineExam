package com.steins.controller;


import com.steins.entity.Teacher;
import com.steins.service.impl.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sunny
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    private Teacher teacher=new Teacher();
//    登录
    @RequestMapping("/login")
    public String login(HttpSession session, HttpServletRequest request, @RequestParam("tid")Integer tid, @RequestParam("password")String password){
        //接收从数据库中查询的信息
        Teacher existTeacher=new Teacher();
        teacher.setTid(tid);
        teacher.setPassword(password);
        existTeacher=teacherService.login(teacher);
        //判断用户是否存在
        if(existTeacher == null){
            request.setAttribute("errMsg","登录失败");
            return "/tdenglu";
        }else{
            //如果用户存在，将用户信息存到session中
            request.setAttribute("success",true);
            session.setAttribute("existTeacher", existTeacher);
            return "/teacher/all";
        }
    }
//    查看教师信息

    @RequestMapping("/select")
    public String select(HttpServletRequest request,@RequestParam("tid") Integer tid){
        teacher=teacherService.ckTeacherXX(tid);
        request.getSession().setAttribute("teacher",teacher);
        return "/teacher/ckxx";
    }
    @RequestMapping("/update")
    public String teacherUpdate(HttpServletRequest request,@RequestParam("tid")Integer tid,@RequestParam("npw")String npw){
        Integer flag=teacherService.updatePW(tid,npw);
        if (flag>0){

            return "/teacher/upwsuccess";
        }
        else {
            request.setAttribute("errMsg","修改失败");
            return "/teacher/upw";
        }
    }
//    安全退出
    @RequestMapping("sessionDestoryteacher")
    public String sessionDestoryteacher(HttpSession session){
        session.invalidate();
        return "/tdenglu";
    }
//    =============================管理员==========================
    //管理员查询所有教师信息
    @RequestMapping("ckAllTeacherAdmin")
    public String ckAllTeacherAdmin(HttpServletRequest request){
        List<Teacher> teacherList=new ArrayList<>();
        teacherList=teacherService.ckAllTeacher();
        request.setAttribute("teacherList",teacherList);
        return "/admin/ckallteacher";
    }
//    管理员根据教师编号查看教师信息
    @RequestMapping("ckTeacherXX")
    public String ckTeacherXX(HttpServletRequest request,@RequestParam("tid")Integer tid){
        teacher=teacherService.ckTeacherXX(tid);
        request.setAttribute("teacher",teacher);
        return "/admin/ckteacherxx";
    }
//    根据教师编号删除教师
    @RequestMapping("deleteTeacherAdmin")
    public String deleteTeacherAdmin(HttpServletRequest request,@RequestParam("tid")Integer tid){
        teacherService.deleteTeacherAdmin(tid);
        List<Teacher> teacherList=new ArrayList<>();
        teacherList=teacherService.ckAllTeacher();
        request.setAttribute("teacherList",teacherList);
        return "/admin/ckallteacher";
    }
    //添加教师
    @RequestMapping("addTeacherAdmin")
    public String addTeacherAdmin(HttpServletRequest request,@RequestParam("tid")Integer tid,@RequestParam("password")String password,@RequestParam("phone")String phone,@RequestParam("tname")String tname){
        teacher.setTid(tid);
        teacher.setPassword(password);
        teacher.setPhone(phone);
        teacher.setTname(tname);
        Integer flag=teacherService.addTeacherSX(teacher);
        if (flag>0){
            return "/teacher/addqsuccess";
        }
        else {
            return "/admin/addteacher";
        }
    }



}
