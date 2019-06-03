package com.steins.controller;

import com.steins.entity.*;
import com.steins.service.impl.TestControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author Sunny
 * 考场设置
 */
@Controller
@RequestMapping("/testControl")
public class testControl {
    @Autowired
    private TestControlService testControlService;
//    进入考试设置界面
    @RequestMapping("/szTest")
    public String szTest(HttpServletRequest request){
        List<QuestionPaper> list = testControlService.ckQuestionPaper();
        request.setAttribute("list", list);
        return "/teacher/sztest";
    }
//    添加考试信息
    @RequestMapping("/addTestControl")
    public String addTestControl(HttpServletRequest request, @RequestParam("qpid")Integer qpid,

                                 @RequestParam("state")Integer state,
                                 @RequestParam("mode")Integer mode,
                                 @RequestParam("tname")String tname
                                 ){
        TestControl testControl=new TestControl();
        testControl.setState(state);
        testControl.setMode(mode);
        testControl.setTname(tname);
        Date date=new Date();
        testControl.setTdate(date);
        testControlService.addTestControl(testControl,qpid);
        return "/teacher/addqsuccess";
    }
    //查看考场信息
    @RequestMapping("/ckTestControl")
    public String ckTestControl(HttpServletRequest request){
        TestControl tc = testControlService.ckTestControl();
        if(tc.getState()==0){
            return "redirect:/testControl/closeTest";
        }else{
            request.setAttribute("tc", tc);
            return "redirect:/testControl/openTest";
        }
    }
//    打开考场
    @RequestMapping("/openTest")
    public String openTest(HttpServletRequest request,@RequestParam("tcid")Integer tcid){

        testControlService.openTest();
        return "/teacher/addqsuccess";
    }
//    关闭考场
    @RequestMapping("/closeTest")
    public String closeTest(HttpServletRequest request,@RequestParam("tcid")Integer tcid){
        testControlService.closeTest(tcid);
        return "/teacher/addqsuccess";
    }
//    考场关闭状态
    @RequestMapping("/closeTestControl")
    public String closeTestControl(HttpServletRequest request){

        return "/student/closeTest";
    }
//    考场开启状态
    @RequestMapping("/openTestControl")
    public String openTestControl(HttpServletRequest request){

        return "/student/ksxz";
    }
//    不可以重复进入考场
    @RequestMapping("/testend")
    public String testend(HttpServletRequest request){

        return "/student/testend";
    }
//    开始考试
    @RequestMapping("/StartTest")
    public String StartTest(HttpServletRequest request){

        return "/student/starttest";
    }
    //    考试记录
    @RequestMapping("/closeTestNote")
    public String closeTestNote(HttpServletRequest request){

        return "/student/testend";
    }
    //查询考试方式
    @RequestMapping("/ckTestControlMode")
    public String ckTestControlMode(HttpServletRequest request,@RequestParam("sid")Integer sid){
        TestControl tc = testControlService.ckTestControl();
        TestNote tn = testControlService.ckTestNote(sid);
        Students stu = testControlService.ckStudents(sid);
        request.setAttribute("stu", stu);
        TestNote tn1 = new TestNote();
        tn1.setStudents(stu);
        tn1.setTdate(tc.getTdate());
        tn1.setTname(tc.getTname());
        if(tn != null && tn.getTname().equals(tc.getTname()) && tn.getTdate().equals(tc.getTdate())){
            return "testend";
        }else{
            //tc.getMode() == 2 表示随机抽取试卷
            if(tc.getMode() == 2){
                //随机抽取试卷
                QuestionPaper qp = testControlService.cqQuestionPaper();
                request.setAttribute("qp", qp);
                Date stime = new Date();
                tn1.setQuestionPaper(qp);
                tn1.setStime(stime);
                //保存考试记录
                testControlService.saveTestNote(tn1);
                TestNote tn2 = testControlService.ckTestNote(sid);
                //将试题和考试记录id保存到AnswerState表中
                testControlService.saveQuestionTN(qp,tn2);
                List<QpRelationq> listxzqpq = testControlService.ckxzQpRelationq(qp.getQpid());
                List<QpRelationq> listpdqpq = testControlService.ckpdQpRelationq(qp.getQpid());
                List<QpRelationq> listtkqpq = testControlService.cktkQpRelationq(qp.getQpid());
                request.setAttribute("listxzqpq", listxzqpq);
                request.setAttribute("listpdqpq", listpdqpq);
                request.setAttribute("listtkqpq", listtkqpq);
                request.setAttribute("tn", tn2);
                return "StartTest";
            }else{
                //指定试卷进行考试
                QuestionPaper qp = testControlService.hqQuestionPaper(tc.getQuestionPaper().getQpid());
                request.setAttribute("qp", qp);
                Date stime = new Date();
                tn1.setQuestionPaper(qp);
                tn1.setStime(stime);
                //保存考试记录
                testControlService.saveTestNote(tn1);
                TestNote tn2 = testControlService.ckTestNote(sid);
                //将试题和考试记录id保存到AnswerState表中
                testControlService.saveQuestionTN(qp,tn2);
                List<QpRelationq> listxzqpq = testControlService.ckxzQpRelationq(qp.getQpid());
                List<QpRelationq> listpdqpq = testControlService.ckpdQpRelationq(qp.getQpid());
                List<QpRelationq> listtkqpq = testControlService.cktkQpRelationq(qp.getQpid());
                request.setAttribute("listxzqpq", listxzqpq);
                request.setAttribute("listpdqpq", listpdqpq);
                request.setAttribute("listtkqpq", listtkqpq);
                request.setAttribute("tn", tn2);
                return "StartTest";
            }
        }
    }
    
}
