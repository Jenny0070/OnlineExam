package com.steins.controller;

import com.steins.entity.Question;
import com.steins.entity.QuestionType;
import com.steins.service.impl.QuestionService;
import com.steins.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Sunny
 * 试卷类型
 */
@RequestMapping("/question")
@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
//    查看选择相似试题
    @RequestMapping("/ckXSXZQuestion")
    public String ckXSXZQuestion(HttpServletRequest request,@RequestParam("oword")String oword,@RequestParam("qscope")String qscope,@RequestParam("qdifficulty")String qdifficulty,@RequestParam("qtid")Integer qtid){
        Question question=new Question();
        question.setOword(oword);
        question.setQdifficulty(qdifficulty);
        question.setQscope(qscope);
        List<Question> listxs = questionService.findByOword(oword, qscope, qdifficulty, qtid);
        request.setAttribute("question", question);
        request.setAttribute("listxs", listxs);
        return "/teacher/ckxsxzquestion";
    }
    @RequestMapping("/ckXSXZAdminQuestion")
    public String ckXSXZAdminQuestion(HttpServletRequest request,@RequestParam("oword")String oword,@RequestParam("qscope")String qscope,@RequestParam("qdifficulty")String qdifficulty,@RequestParam("qtid")Integer qtid){
        Question question=new Question();
        question.setOword(oword);
        question.setQdifficulty(qdifficulty);
        question.setQscope(qscope);
        List<Question> listxs = questionService.findByOword(oword, qscope, qdifficulty, qtid);
        request.setAttribute("question", question);
        request.setAttribute("listxs", listxs);
        return "/admin/ckxsxzquestion";
    }
//    添加选择题
    @RequestMapping("addQuestionXZ")
    public  String addQuestionXZ(HttpServletRequest request){

        return "/teacher/addquestionxz";
    }
    //    添加选择题
    @RequestMapping("addAdminQuestionXZ")
    public  String addAdminQuestionXZ(HttpServletRequest request){

        return "/admin/addquestionxz";
    }//    添加选择题实现管理员
    @RequestMapping("/addQuestionXZSX")
    public  String addQuestionXZSX(HttpServletRequest request,@RequestParam("qcontent") String qcontent,
                                   @RequestParam("aoption")String aoption,
                                   @RequestParam("boption")String boption,
                                   @RequestParam("coption")String coption,
                                   @RequestParam("doption")String doption,
                                   @RequestParam("qanswer")String qanswer,
                                   @RequestParam("qanalysis")String qanalysis,
                                   @RequestParam("oword")String oword,
                                   @RequestParam("qscope")String qscope,
                                   @RequestParam("qdifficulty")String qdifficulty
                                   ){
        Question question=new Question();
        Integer qtid= 1;
        question.setQcontent(qcontent);
        question.setAoption(aoption);
        question.setBoption(boption);
        question.setCoption(coption);
        question.setDoption(doption);
        question.setQanswer(qanswer);
        question.setQanalysis(qanalysis);
        question.setOword(oword);
        question.setQscope(qscope);
        question.setQdifficulty(qdifficulty);
        long qdate=System.currentTimeMillis();

        question.setQdate(qdate);
        questionService.addAdminQuestionXZSX(question,qtid);

        return "/teacher/upwsuccess";
    }

    //    查看判断相似试题
    @RequestMapping("/ckXSPDQuestion")
    public  String ckXSPDQuestion(HttpServletRequest request,@RequestParam("oword")String oword,@RequestParam("qscope")String qscope,@RequestParam("qdifficulty")String qdifficulty){
       Integer qtid=3;
        List<Question> listxs = questionService.findByOword(oword,qscope,qdifficulty,qtid);
        Question question=new Question();
        question.setOword(oword);
        question.setQscope(qscope);
        question.setQdifficulty(qdifficulty);
        request.setAttribute("question", question);
        request.setAttribute("listxs", listxs);
        return "/teacher/ckxspdquestion";
    }
    @RequestMapping("/ckXSPDAdminQuestion")
    public  String ckXSPDAdminQuestion(HttpServletRequest request,@RequestParam("oword")String oword,@RequestParam("qscope")String qscope,@RequestParam("qdifficulty")String qdifficulty,@RequestParam("qtid")Integer qtid){
        List<Question> listxs = questionService.findByOword(oword,qscope,qdifficulty,qtid);
        Question question=new Question();
        question.setOword(oword);
        question.setQscope(qscope);
        question.setQdifficulty(qdifficulty);
        request.setAttribute("question", question);
        request.setAttribute("listxs", listxs);
        return "/admin/ckxspdquestion";
    }
    //    添加判断题
    @RequestMapping("/addQuestionPD")
    public  String addQuestionPD(HttpServletRequest request,@RequestParam("oword")String oword,@RequestParam("qscope")String qscope,@RequestParam("qdifficulty")String qdifficulty){
        Integer qtid=2;
        Question question=new Question();
        question.setOword(oword);
        question.setQscope(qscope);
        question.setQdifficulty(qdifficulty);
        questionService.addQuestionPD(question,qtid);
        return "/teacher/upwsuccess";
    }
    //    添加填空题
    @RequestMapping("/addQuestionTK")
    public  String addQuestionTK(HttpServletRequest request,@RequestParam("oword")String oword,@RequestParam("qscope")String qscope,@RequestParam("qdifficulty")String qdifficulty){
        Integer qtid=3;
        Question question=new Question();
        question.setOword(oword);
        question.setQscope(qscope);
        question.setQdifficulty(qdifficulty);
        questionService.addQuestionTK(question,qtid);
        return "/teacher/upwsuccess";
    }//
    @RequestMapping("addAdminQuestionPD")
    public  String addAdminQuestionPD(HttpServletRequest request){

        return "/admin/addquestionpd";
    }//    添加判断题实现
    @RequestMapping("addQuestionPDSX")
    public  String addQuestionPDSX(HttpServletRequest request){

        return "/teacher/addqsuccess";
    }//    查看填空相似试题
    @RequestMapping("ckXSTKQuestion")
    public  String ckXSTKQuestion(HttpServletRequest request){

        return "/teacher/ckxstkquestion";
    }
    @RequestMapping("ckXSTKAdminQuestion")
    public  String ckXSTKAdminQuestion(HttpServletRequest request){

        return "/admin/ckxstkquestion";
    }
//    添加填空题
//    @RequestMapping("addQuestionTK")
//    public  String addQuestionTK(HttpServletRequest request){
//
//        return "/teacher/addquestiontk";
//    }
    @RequestMapping("addAdminQuestionTK")
    public  String addAdminQuestionTK(HttpServletRequest request){

        return "/admin/addquestiontk";
    }
//    添加填空题实现
    @RequestMapping("addQuestionTKSX")
    public  String addQuestionTKSX(HttpServletRequest request){

        return "/teacher/addqsuccess";
    }
//    选择查找试题的试题类型
    @RequestMapping("ckQuestionAndXZQT")
    public  String ckQuestionAndXZQT(HttpServletRequest request){
        List<QuestionType> listqt = questionService.ckQuestionAndXZQT();
        request.setAttribute("listqt", listqt);
        return "/teacher/ckqxzqt";
    }
    @RequestMapping("ckAdminQuestionAndXZQT")
    public  String ckAdminQuestionAndXZQT(HttpServletRequest request){
        List<QuestionType> listqt = questionService.ckQuestionAndXZQT();
        request.setAttribute("listqt", listqt);
        return "/admin/ckqxzqt";
    }
//   查找试题
    @RequestMapping("ckQuestion")
    public  String ckQuestion(HttpServletRequest request, @RequestParam("qid")Integer qid, @RequestParam("tid")Integer tid, @RequestParam("qtid")Integer qtid, @RequestParam("page")Integer page){
        Question question=new Question();
        if(qid!=null){
            question = questionService.selectQuestion(qid);
        }
        PageBean<Question> pageBean = questionService.ckQuestion(question,tid,qtid,page);
        request.setAttribute("pageBean", pageBean);
        List<QuestionType> listqt = questionService.ckQuestionAndXZQT();
        request.setAttribute("listqt", listqt);
        request.setAttribute("pageqtid", qtid);
        return "/teacher/ckqxzqt";
    }
//    管理员查找试题
    @RequestMapping("ckAdminQuestion")
    public  String ckAdminQuestion(HttpServletRequest request, @RequestParam("qid")Integer qid, @RequestParam("qtid")Integer qtid, @RequestParam("page")Integer page){
        Question question=new Question();
        if(qid!=null){
            question = questionService.selectQuestion(qid);
        }
        PageBean<Question> pageBean = questionService.ckAdminQuestion(question,qtid,page);
        request.setAttribute("pageBean", pageBean);
        List<QuestionType> listqt = questionService.ckQuestionAndXZQT();
        request.setAttribute("listqt", listqt);
        request.setAttribute("pageqtid", qtid);
        return "/admin/ckqxzqt";
    }
//    查看选择题详细信息
    @RequestMapping("ckXZQuestion")
    public  String ckXZQuestion(HttpServletRequest request){

        return "/teacher/ckxzquestion";
    }
//    查看填空题详细信息
    @RequestMapping("ckTKQuestion")
    public  String ckTKQuestion(HttpServletRequest request){

        return "/teacher/cktkquestion";
    }
//    查看判断题详细信息
    @RequestMapping("ckPDQuestion")
    public  String ckPDQuestion(HttpServletRequest request){

        return "/teacher/ckpdquestion";
    }

}
