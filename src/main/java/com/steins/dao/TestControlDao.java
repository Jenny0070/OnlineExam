package com.steins.dao;

import com.steins.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestControlDao {
    //查询所有试卷
    public List<QuestionPaper> ckQuestionPaper();
    //添加考试信息
    public void addTestControl(@Param("testControl") TestControl testControl, @Param("qpid")Integer qpid);
//    查看全部testControl信息
    public List<TestControl> selectAllTestControl();
    List<TestControl> getAllTestControl();
//    //打开考场
    public void openTest();
//    //关闭考场
    public void closeTest(Integer tcid);
    //查看考场信息
    public TestControl ckTestControl();
    //根据学号查询考试记录
    public TestNote ckTestNote(Integer sid);
    //随机抽取试卷
    public QuestionPaper cqQuestionPaper();
    //根据学号查询学生
    public Students ckStudents(Integer sid);
    //保存考试记录
    public void saveTestNote(TestNote tn1);
    //根据试卷id查询试卷信息
    public QuestionPaper hqQuestionPaper(Integer qpid);
//    一下三个待选
    //根据试卷id查询选择题
    public List<QpRelationq> ckxzQpRelationq(Integer qpid);
    //根据试卷id查询判断题
    public List<QpRelationq> ckpdQpRelationq(Integer qpid);
    //根据试卷id查询填空题
    public List<QpRelationq> cktkQpRelationq(Integer qpid);
    //根据试卷id查询试题与试卷的对应关系
    public List<QpRelationq> getQpq(Integer qpid);
    //根据试题id查询试题对象
    public Question czQuestion(Integer qid);
    //将试题与考试记录保存到answerState中
    public void saveAnswerState(AnswerState a);

}
