package com.steins.service.impl;

import java.util.List;

import com.steins.dao.TeacherDao;
import com.steins.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class TeacherService {
	//注入TeacherDao
	@Autowired
	private TeacherDao teacherDao;

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	public Teacher login(Teacher teacher) {

		return teacherDao.login(teacher);
	}

	public Integer updatePW(Integer tid, String npw) {
		Integer flag=teacherDao.updatePW(tid,npw);
        return flag;
    }
	//查询所有教师信息
	public List<Teacher> ckAllTeacher() {
		return teacherDao.ckAllTeacher();
	}
	//根据教师编号查询教师信息
	public Teacher ckTeacherXX(Integer tid) {
		return teacherDao.ckTeacherXX(tid);
	}
	//根据教师编号删除教师
	public void deleteTeacherAdmin(Integer tid) {
		teacherDao.deleteTeacherAdmin(tid);
	}
	//添加教师
	public Integer addTeacherSX(Teacher teacher) {
		Integer flag=teacherDao.addTeacherSX(teacher);
        return flag;
    }
}
