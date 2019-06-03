package com.steins.dao;

import com.steins.entity.BJ;
import com.steins.entity.Students;

import java.util.List;

public interface BJDao {
    //按教师号查询班级信息
    public List<BJ> ckbj(Integer tid);

    public List<BJ> ckbjAdmin();
    //添加班级时验证班级名称是否重复
    public BJ findByName(String bjname);
//    添加班级_注意tid
    public Integer addbjsx(BJ bj);
    public void deleteBJ(Integer bjid);
    //根据班级id查询班级里所有的学生信息_???不确定语句对不对
    public List<Students> ckBJStudents(Integer bjid);
    //根据学号删除学生信息
    public void deleteBJStudent(Integer sid);
}
