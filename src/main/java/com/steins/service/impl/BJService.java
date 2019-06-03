package com.steins.service.impl;

import com.steins.dao.BJDao;
import com.steins.entity.BJ;
import com.steins.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BJService {
	@Autowired
	private BJDao bjDao;

	public List<BJ> ckbj(Integer tid) {
		List<BJ> list = bjDao.ckbj(tid);
		return list;
	}
	public List<BJ> ckbjAdmin() {
		List<BJ> list = bjDao.ckbjAdmin();
		return list;
	}
    //按班级名查询班级的方法
	public BJ findByName(String bjname){
		return bjDao.findByName(bjname);
	}
    //添加班级信息
	public Integer addbjsx(BJ bj, Integer tid) {
		Integer flag=bjDao.addbjsx(bj);
        return flag;
    }

    //根据班级id删除班级
	public void deleteBJ(Integer bjid) {
		bjDao.deleteBJ(bjid);
	}
    //根据班级id查询该班级里所有的学生
	public List<Students> ckBJStudents(Integer bjid) {
		return bjDao.ckBJStudents(bjid);
	}
    //根据学号删除学生信息
	public void deleteBJStudent(Integer sid) {
		bjDao.deleteBJStudent(sid);
	}

	
	
}
