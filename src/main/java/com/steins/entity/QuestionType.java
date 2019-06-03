package com.steins.entity;

import java.util.HashSet;
import java.util.Set;

public class QuestionType {
	private Integer qtid;
	private String qtname;
	private Integer score;
	private Set<Question> questions = new HashSet<Question>();	
	
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	public Integer getQtid() {
		return qtid;
	}
	public void setQtid(Integer qtid) {
		this.qtid = qtid;
	}
	public String getQtname() {
		return qtname;
	}
	public void setQtname(String qtname) {
		this.qtname = qtname;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
}
