package com.steins.service.impl;


import com.steins.dao.AnswerStateDao;
import com.steins.entity.AnswerState;
import com.steins.entity.Question;
import com.steins.entity.TestNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class AnswerStateService {
	@Autowired
	private AnswerStateDao answerStateDao;
    //保存试题答案
	public Integer saveAnswerState(Integer tnid, Integer qid, String qas) {
		AnswerState a = answerStateDao.hqAnswerState(tnid,qid);
		Question q = answerStateDao.hqQuestion(qid);
		TestNote tn = answerStateDao.hqTestNote(tnid);
		if(qas.equals(q.getQanswer())){
			a.setState(1);
		}else{
			a.setState(2);
		}
		a.setQuestion(q);
		a.setTestNote(tn);
		Integer flag=answerStateDao.saveAnswerState(a);
		return flag;
	}
}
