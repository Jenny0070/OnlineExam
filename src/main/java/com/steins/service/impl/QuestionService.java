package com.steins.service.impl;

import com.steins.dao.QuestionDao;
import com.steins.entity.Question;
import com.steins.entity.QuestionType;
import com.steins.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class QuestionService {
	@Autowired
	private QuestionDao questionDao;

	public List<QuestionType> ckQuestionAndXZQT() {
		return questionDao.ckQuestionAndXZQT();
	}
	//根据教师编号、试题类型编号、等查询试题
	public PageBean<Question> ckQuestion(Question question, Integer tid,
										 Integer qtid,int page) {
		PageBean<Question> pageBean = new PageBean<Question>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示的记录数
		int limit = 3;
		pageBean.setLimit(limit);
		//设置总的记录数
		int totalCount = 0;
		totalCount = questionDao.findCount(question,tid,qtid);
		pageBean.setTotalCount(totalCount);
		//设置总的页数
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount /limit ;
		}else{
			totalPage = totalCount / limit +1;
		}
		pageBean.setTotalPage(totalPage);
		//每页显示的数据集合
		//从哪条记录开始
		int begin = (page - 1) * limit;
		List<Question> list = questionDao.findQuestion(question,tid,qtid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	//管理员根据试题类型编号、等查询试题
	public PageBean<Question> ckAdminQuestion(Question question, Integer qtid,
											  int page) {
		PageBean<Question> pageBean = new PageBean<Question>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示的记录数
		int limit = 3;
		pageBean.setLimit(limit);
		//设置总的记录数
		int totalCount = 0;
		totalCount = questionDao.findCountAdmin(question,qtid);
		pageBean.setTotalCount(totalCount);
		//设置总的页数
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount /limit ;
		}else{
			totalPage = totalCount / limit +1;
		}
		pageBean.setTotalPage(totalPage);
		//每页显示的数据集合
		//从哪条记录开始
		int begin = (page - 1) * limit;
		List<Question> list = questionDao.findQuestionAdmin(question,qtid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public Question selectQuestion(Integer qid) {

		return questionDao.selectQuestion(qid);
	}

	//根据关键字查找是否有相似的试题
	public List<Question> findByOword(String oword,String qscope,String qdifficulty,Integer qtid) {

		return questionDao.finByOword(oword,qscope,qdifficulty,qtid);
	}
	//添加试题实现
	public void addQuestionXZSX(Question question,Integer qtid, Integer tid) {
		questionDao.addQuestionXZSX(question,qtid,tid);
	}
	public void addAdminQuestionXZSX(Question question, Integer qtid) {
		questionDao.addAdminQuestionXZSX(question,qtid);
	}
	//根据试题编号查看试题信息
	public Question ckQuestionXX(Integer qid) {
		return questionDao.ckQuestionXX(qid);
	}
	//根据试题编号删除试题
	public void delQuestion(Integer qid) {
		questionDao.delQuestion(qid);
	}


	public void addQuestionPD(Question question, Integer qtid) {
		questionDao.addQuestionPD(question,qtid);
	}
	public void addQuestionTK(Question question, Integer qtid) {
		questionDao.addQuestionTK(question,qtid);
	}
}

