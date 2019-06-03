package com.steins.service.impl;

import com.steins.dao.TestNoteDao;

import com.steins.entity.TestNote;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
@Service
@Transactional
public class TestNoteService {
	private TestNoteDao tnDao;

	public void setTnDao(TestNoteDao tnDao) {
		this.tnDao = tnDao;
	}

	public void upEndTime(Integer tnid) {
		TestNote tn = tnDao.getTestNote(tnid);
		tn.setEtime(new Date());
		tnDao.saveTestNote(tn);
	}
}
