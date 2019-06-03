package com.steins.dao;

import com.steins.entity.AnswerState;
import com.steins.entity.BJ;
import com.steins.entity.Students;
import com.steins.entity.TestNote;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    public Students login(@Param("student") Students student);
    public int findCountTid(Integer tid);
    public int findCountAdmin();
    //???
    public List<Students> findByPageTid(@Param("tid") Integer tid, @Param("begin")int begin,@Param("limit") int limit);
    //???
    public List<Students> findByPageAdmin(@Param("begin")int begin,@Param("limit") int limit);
    public List<BJ> ckbj(Integer tid);
    public List<BJ> ckbjAdmin();
    public Students finBySid(Integer sid);
    public void addStudentSX(@Param("student")Students student, @Param("bjid")Integer bjid);
    public void deleteStudent(Integer sid);
//    根据学号查询学生信息???
    public List<TestNote> ckTestNote(Integer sid);
    //根据考试记录编号查询选择题——以下三个？？？
    public List<AnswerState> ckAnserStatexz(Integer tnid);
    public List<AnswerState> ckAnserStatepd(Integer tnid);
    public List<AnswerState> ckAnserStatetk(Integer tnid);
    public void updatePW(@Param("sid")Integer sid, @Param("npw")String npw);
    public Students ckStudent(Integer sid);
    public void wsStudentSX(Students student);
    public BJ myBJ(Integer sid);
    public Students ckStudentXX(Integer sid);
}
