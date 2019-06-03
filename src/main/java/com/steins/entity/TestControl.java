package com.steins.entity;


import java.util.Date;

/**
 * @author Sunny
 */
public class TestControl {
	private Integer tcid;
	private Integer state;
	private Integer mode;
	private String tname;
	private Date tdate;
	private QuestionPaper questionPaper;
	
	public QuestionPaper getQuestionPaper() {
		return questionPaper;
	}
	public void setQuestionPaper(QuestionPaper questionPaper) {
		this.questionPaper = questionPaper;
	}
	public Integer getTcid() {
		return tcid;
	}
	public void setTcid(Integer tcid) {
		this.tcid = tcid;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getMode() {
		return mode;
	}
	public void setMode(Integer mode) {
		this.mode = mode;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Date getTdate() {
		return tdate;
	}
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
	
}
