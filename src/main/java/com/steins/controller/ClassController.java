package com.steins.controller;

import com.steins.entity.BJ;
import com.steins.entity.Students;
import com.steins.entity.Teacher;
import com.steins.service.impl.BJService;
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
 * 班级管理
 */
@Controller
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private BJService bjService;

//
//    教师查看班级
    @RequestMapping("/ckbj")
    public String ckbj(HttpServletRequest request, HttpSession session){
        Teacher teacher= (Teacher) session.getAttribute("existTeacher");
        List<BJ> bjList=new ArrayList<>();
        bjList=bjService.ckbj(teacher.getTid());
        request.setAttribute("bjList",bjList);
        return "/teacher/ckbj";

    }
//    管理员查看班级
    @RequestMapping("ckbjAdmin")
    public String ckbjAdmin(HttpServletRequest request){
        List<BJ> bjList=new ArrayList<>();
        bjList=bjService.ckbjAdmin();
        request.setAttribute("bjList",bjList);
        return "/admin/ckbj";
    }
//    添加班级
    @RequestMapping("addbjsx")
    public String addbjsx(HttpServletRequest  request, HttpSession session,@RequestParam("bjname") String bjname){
        BJ bj=new BJ();
        Teacher teacher= (Teacher) session.getAttribute("existTeacher");
        int tid=teacher.getTid();
        bj.setBjname(bjname);
        bj.setTid(teacher.getTid());
        Integer flag=bjService.addbjsx(bj,tid);
        if (flag>0){
            return "redirect:/class/ckbj";
        }
        else {
            return "/teacher/ckbj";
        }

    }
//
   @RequestMapping("deleteBJ")
    public  String deleteBJ(HttpServletRequest request,@RequestParam("bjid")Integer bjid){
        bjService.deleteBJ(bjid);
        return "redirect:/class/ckb";

    }
//    查看班级里所有学生的信息
    @RequestMapping("ckBJStudents")
    public String ckBJStudents(HttpServletRequest request,HttpSession session,@RequestParam("bjid")Integer bjid){
        List<Students> studentsList = bjService.ckBJStudents(bjid);
        session.setAttribute("bjid",bjid);
        request.setAttribute("studentsList",studentsList);
        return "/teacher/ckbjstudents";
    }


}
