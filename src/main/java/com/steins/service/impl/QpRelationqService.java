package com.steins.service.impl;


import com.steins.dao.QpRelationqDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class QpRelationqService {
	@Autowired
	private QpRelationqDao qprqDao;

	public void setQprqDao(QpRelationqDao qprqDao) {
		this.qprqDao = qprqDao;
	}
}
