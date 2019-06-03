package com.steins.service.impl;

import com.steins.dao.TestControlDao;
import com.steins.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TestControlService {
	@Autowired
	private TestControlDao tcDao;

	public void setTcDao(TestControlDao tcDao) {
		this.tcDao = tcDao;
	}
	//查看试卷
	public List<QuestionPaper> ckQuestionPaper() {
		return tcDao.ckQuestionPaper();
	}
	//添加考试信息
	public void addTestControl(TestControl testControl, Integer qpid) {
		tcDao.addTestControl(testControl,qpid);
	}
	//打开考场
	public void openTest() {
		List<TestControl> list=new ArrayList<>();
		TestControl testControl=new TestControl();
		testControl=list.get(0);
		testControl.setState(1);
		tcDao.openTest();
	}
	//关闭考场
	public void closeTest(Integer tcid) {
		tcDao.closeTest(tcid);
	}
	//查看考场信息
	public TestControl ckTestControl() {
		return tcDao.ckTestControl();
	}
	//查询考试记录
	public TestNote ckTestNote(Integer sid) {
		return tcDao.ckTestNote(sid);
	}
	//随机抽取试卷
	public QuestionPaper cqQuestionPaper() {

		return tcDao.cqQuestionPaper();
	}
	//根据学号查询学生
	public Students ckStudents(Integer sid) {
		return tcDao.ckStudents(sid);
	}
	//保存考试记录
	public void saveTestNote(TestNote tn1) {
		tcDao.saveTestNote(tn1);
	}

	//根据试卷id获取试卷信息
	public QuestionPaper hqQuestionPaper(Integer qpid) {
		return tcDao.hqQuestionPaper(qpid);
	}
	//根据试卷id查询选择题
	public List<QpRelationq> ckxzQpRelationq(Integer qpid) {
		return tcDao.ckxzQpRelationq(qpid);
	}
	//根据试卷id查询判断题
	public List<QpRelationq> ckpdQpRelationq(Integer qpid) {
		return tcDao.ckpdQpRelationq(qpid);
	}
	//根据试卷id查询填空题
	public List<QpRelationq> cktkQpRelationq(Integer qpid) {
		return tcDao.cktkQpRelationq(qpid);
	}
	//将试题id和testnote保存到answerState中
	public void saveQuestionTN(QuestionPaper qp, TestNote tn2) {
		List<QpRelationq> listqpq = tcDao.getQpq(qp.getQpid());
		Question q = null;
		for(int i=0; i<listqpq.size(); i++){
			AnswerState a = new AnswerState();
			a.setTestNote(tn2);
			a.setState(3);
			q = tcDao.czQuestion(listqpq.get(i).getQuestion().getQid());
			a.setQuestion(q);
			tcDao.saveAnswerState(a);
		}
	}
}
