package com.steins.dao;

import com.steins.entity.Question;
import com.steins.entity.QuestionType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Sunny
 */
public interface QuestionDao {
//    选择问题类型
    public List<QuestionType> ckQuestionAndXZQT();
    //获取符合条件的试题总数
    public int findCount(@Param("question") Question question, @Param("tid") Integer tid, @Param("qtid") Integer qtid);
    //获取符合条件的试题总数
    public int findCountAdmin(@Param("question") Question question, @Param("qtid") Integer qtid);
    //根据条件获取试题集合
    public List<Question> findQuestion(@Param("question")Question question,  @Param("tid")Integer tid,
                                       @Param("qtid")Integer qtid, @Param("begin") int begin, @Param("limit") int limit);
    //根据条件获取试题集合
    public List<Question> findQuestionAdmin(@Param("question")Question question,@Param("qtid")Integer qtid,
                                           @Param("begin") int begin, @Param("limit") int limit);
    public Question selectQuestion(Integer qid);
    //关键关键字查找相似试题
    public List<Question> finByOword(@Param("oword") String oword,@Param("qscope") String qscope,@Param("qdifficulty") String qdifficulty,@Param("qtid") Integer qtid);

    public void addQuestionXZSX(@Param("question") Question question,@Param("qtid") Integer qtid,@Param("tid") Integer tid);
    public void addAdminQuestionXZSX(@Param("question")Question question, @Param("qtid")Integer qtid);
    //根据试题编号查看试题信息
    public Question ckQuestionXX(Integer qid);
    //根据试题编号删除试题
    public void delQuestion(Integer qid);

    void addQuestionPD(@Param("question") Question question, @Param("qtid")Integer qtid);
    void addQuestionTK(@Param("question")Question question, @Param("qtid")Integer qtid);
}
