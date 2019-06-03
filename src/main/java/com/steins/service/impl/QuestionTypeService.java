package com.steins.service.impl;

import com.steins.dao.QuestionTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class QuestionTypeService {
@Autowired
	private QuestionTypeDao qtDao;

//	public void setQtDao(QuestionTypeDao qtDao) {
//		this.qtDao = qtDao;
//	}
}
