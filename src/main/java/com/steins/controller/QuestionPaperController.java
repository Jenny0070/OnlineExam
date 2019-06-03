package com.steins.controller;

import com.steins.entity.QpRelationq;
import com.steins.entity.Question;
import com.steins.entity.QuestionPaper;
import com.steins.entity.QuestionType;
import com.steins.service.impl.QuestionPaperService;
import com.steins.service.impl.QuestionService;
import com.steins.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author Sunny
 * 试卷
 */
@Controller
@RequestMapping("/questionPaper")
public class QuestionPaperController {
    @Autowired 
    private QuestionPaperService questionPaperService;
//    设置试卷基本信息
    @RequestMapping("/szQuestionPaper")
    public String szQuestionPaper (HttpServletRequest request){

        return "/teacher/szquestionpaper";
    }
    @RequestMapping("/szAdminQuestionPaper")
    public String szAdminQuestionPaper  (){

        return "/admin/szquestionpaper";
    }
//    为试卷添加试题
    @RequestMapping("/tjQuestionPaper")
    public String tjQuestionPaper(HttpServletRequest request,@RequestParam("tid")Integer tid,@RequestParam("time")Integer time){
        QuestionPaper questionPaper=new QuestionPaper();
        long qpdate = System.currentTimeMillis();
        questionPaper.setQpdate(qpdate);
        questionPaper.setTime(time);

        questionPaperService.szQuestionPaper(questionPaper,tid);
        List<QuestionType> listqt = questionPaperService.allQT();
        questionPaper = questionPaperService.getQuestionPaper();  //查询试卷获取试卷id
        request.setAttribute("listqt", listqt);
        request.setAttribute("questionPaper", questionPaper);
        return "/teacher/tjquestionpaper";
    }
//   admin为试卷添加试题 
    @RequestMapping("/tjAdminQuestionPaper")
    public String tjAdminQuestionPaper(HttpServletRequest request,@RequestParam("time")Integer time){
        long qpdate =System.currentTimeMillis();
        QuestionPaper questionPaper=new QuestionPaper();
        questionPaper.setQpdate(qpdate);
        questionPaper.setTime(time);
        questionPaperService.szAdminQuestionPaper(questionPaper);
        List<QuestionType> listqt = questionPaperService.allQT();
        questionPaper = questionPaperService.getQuestionPaper();  //查询试卷获取试卷id
        request.setAttribute("listqt", listqt);
        request.setAttribute("questionPaper", questionPaper);
        return "/admin/tjquestionpaper";
    }

//    显示试卷已有试题，并且添加新试题
    @RequestMapping("/tjQuestion")
    public String tjQuestion (HttpServletRequest request,@RequestParam("qid")Integer qid,
                              @RequestParam("tid")Integer tid,
                              @RequestParam("qtid")Integer qtid,
                              @RequestParam("page")Integer page,
                              @RequestParam("time")Integer time

    ){
        Question question=new Question();
        if(qid!=null){
            question = questionPaperService.selectQuestion(qid);
        }
        QuestionPaper questionPaper=new QuestionPaper();
        long qpdate =System.currentTimeMillis();
        questionPaper.setTime(time);
        PageBean<Question> pageBean = questionPaperService.ckQuestion(question,tid,qtid,page);
        request.setAttribute("pageBean", pageBean);
        List<Question> listqpq = questionPaperService.qpQuestion(questionPaper.getQpid()); //查找试卷中已有的试题
        List<QuestionType> listqt = questionPaperService.allQT();
         request.setAttribute("questionPaper", questionPaper);
         request.setAttribute("listqt", listqt);
         request.setAttribute("pageqtid", qtid);
         request.setAttribute("listqpq", listqpq);

        return "/teacher/tjquestionpaper";
    }
    @RequestMapping("/tjAdminQuestion")
    public String tjAdminQuestion (HttpServletRequest request,@RequestParam("qid")Integer qid,
                              @RequestParam("qtid")Integer qtid,
                              @RequestParam("page")Integer page,
                              @RequestParam("time")Integer time

    ){
        Question question=new Question();
        if(qid!=null){
            question = questionPaperService.selectQuestion(qid);
        }
        QuestionPaper questionPaper=new QuestionPaper();
        long qpdate =System.currentTimeMillis();
        questionPaper.setQpdate(qpdate);
        questionPaper.setTime(time);
        PageBean<Question> pageBean = questionPaperService.ckAdminQuestion(question,qtid,page);
        request.setAttribute("pageBean", pageBean);
        List<Question> listqpq = questionPaperService.qpQuestion(questionPaper.getQpid()); //查找试卷中已有的试题
        List<QuestionType> listqt = questionPaperService.allQT();
        request.setAttribute("questionPaper", questionPaper);
        request.setAttribute("listqt", listqt);
        request.setAttribute("pageqtid", qtid);
        request.setAttribute("listqpq", listqpq);


        return "/admin/tjquestionpaper";
    }
//    添加试题实现
    @RequestMapping("/tjQuestionSX")
    public String tjQuestionSX (HttpServletRequest request,@RequestParam("qpid")Integer qpid,@RequestParam("qid")Integer qid,@RequestParam("num")Integer num){
        questionPaperService.tjQuestionSX(qpid,qid,num);
        List<Question> listqpq = questionPaperService.qpQuestion(qpid); //查找试卷中已有的试题
        List<QuestionType> listqt = questionPaperService.allQT();
        QuestionPaper questionPaper=new QuestionPaper();
        long qpdate =System.currentTimeMillis();
        request.setAttribute("listqt", listqt);
        request.setAttribute("questionPaper", questionPaper);
        request.setAttribute("listqpq", listqpq);

        return "/teacher/tjquestionpaper";
    }
    @RequestMapping("/tjAdminQuestionSX")
    public String  tjAdminQuestionSX(HttpServletRequest request,@RequestParam("qpid")Integer qpid,@RequestParam("qid")Integer qid,@RequestParam("num")Integer num){
        questionPaperService.tjQuestionSX(qpid,qid,num);
        List<Question> listqpq = questionPaperService.qpQuestion(qpid); //查找试卷中已有的试题
        List<QuestionType> listqt = questionPaperService.allQT();
        QuestionPaper questionPaper=new QuestionPaper();
        long qpdate =System.currentTimeMillis();
        questionPaper.setQpdate(qpdate);
        request.setAttribute("listqt", listqt);
        request.setAttribute("questionPaper", questionPaper);
        request.setAttribute("listqpq", listqpq);

        return "/admin/tjquestionpaper";
    }
//    查看试卷
    @RequestMapping("/ckQuestionPaper")
    public String ckQuestionPaper  (HttpServletRequest request,@RequestParam("tid")Integer tid){
        List<QuestionPaper> list = questionPaperService.ckQuestionPaper(tid);
        request.setAttribute("list", list);
        return "/teacher/ckqp";
    }
    @RequestMapping("/ckAdminQuestionPaper")
    public String ckAdminQuestionPaper  (HttpServletRequest request, HttpSession session){
        List<QuestionPaper> list = questionPaperService.ckAdminQuestionPaper();
        session.setAttribute("list", list);
        return "/admin/ckqp";
    }
//    查看试卷中试题
    @RequestMapping("/ckQPQuestion")
    public String ckQPQuestion(HttpServletRequest request,@RequestParam("qpid")Integer qpid){
        System.out.println(qpid+"=============");
        List<Question> listqpq = questionPaperService.qpQuestion(qpid);
        request.setAttribute("listqpq", listqpq);
        return "/teacher/ckqpquestion";
    }





}
