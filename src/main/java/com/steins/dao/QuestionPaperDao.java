package com.steins.dao;

import com.steins.entity.QpRelationq;
import com.steins.entity.Question;
import com.steins.entity.QuestionPaper;
import com.steins.entity.QuestionType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionPaperDao {
    public void szQuestionPaper(@Param("questionPaper")QuestionPaper questionPaper,@Param("tid") Integer tid);
    public void szAdminQuestionPaper(@Param("questionPaper")QuestionPaper questionPaper);
    public Question selectQuestion(Integer qid);
    public int findCount(@Param("question") Question question, @Param("tid")Integer tid,@Param("qtid") Integer qtid);
    public int findCountAdmin(@Param("question")Question question,@Param("qtid") Integer qtid);
    public List<Question> findQuestion(@Param("question")Question question,@Param("tid")Integer tid,
                                       @Param("qtid")Integer qtid, @Param("begin")int begin, @Param("limit")int limit);
    public List<Question> findQuestionAdmin(@Param("question")Question question, @Param("qtid")Integer qtid,
                                            @Param("begin")int begin, @Param("limit")int limit);
    public List<QuestionPaper> getQuestionPaper();
//    //查询所有试题类型
	public List<QuestionType> allQT();
    public void tjQuestionSX(@Param("qpid")Integer qpid, @Param("qid")Integer qid, @Param("num")Integer num);
    public List<Question> qpQuestion(@Param("qpid") Integer qpid);
    public List<QuestionPaper> ckQuestionPaper(@Param("tid") Integer tid);
    public List<QuestionPaper> ckAdminQuestionPaper();


}
