package com.steins.dao;

import com.steins.entity.AnswerState;
import com.steins.entity.Question;
import com.steins.entity.TestNote;
import org.apache.ibatis.annotations.Param;

public interface AnswerStateDao {
    //根据试题id和tnid查询answerState
    public AnswerState hqAnswerState(@Param("tnid") Integer tnid, @Param("qid") Integer qid);
    //根据试题编号查询试题
    public Question hqQuestion(Integer qid);
    //根据考试记录编号查询考试记录
    public TestNote hqTestNote(Integer tnid);
    //保存学生答题情况
    public Integer saveAnswerState(AnswerState a);
}
