package com.steins.dao;

import com.steins.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDao {
    public Teacher login(Teacher teacher);
    public Integer updatePW(@Param("tid") Integer tid, @Param("npw")String npw);
    public List<Teacher> ckAllTeacher();
    //根据
    public Teacher ckTeacherXX(Integer tid);
    //根据教师编号删除教师
    public void deleteTeacherAdmin(Integer tid);
    public Integer addTeacherSX(Teacher teacher);

}
