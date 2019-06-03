package com.steins.entity;


import java.util.HashSet;
import java.util.Set;

public class Question {
	private Integer qid;
	private String qcontent;
	private String aoption;
	private String boption;
	private String coption;
	private String doption;
	private String qanswer;
	private String qanalysis;
	private String oword;
	private String qscope;
	private String qdifficulty;
	private long qdate;
	private QuestionType questionType;
	private Teacher teacher;
	private Set<QpRelationq> qpRelationq = new HashSet<QpRelationq>();
	private Set<AnswerState> answerState = new HashSet<AnswerState>();
	public Set<AnswerState> getAnswerState() {
		return answerState;
	}
	public void setAnswerState(Set<AnswerState> answerState) {
		this.answerState = answerState;
	}
	public Set<QpRelationq> getQpRelationq() {
		return qpRelationq;
	}
	public void setQpRelationq(Set<QpRelationq> qpRelationq) {
		this.qpRelationq = qpRelationq;
	}
	public Integer getQid() {
		return qid;
	}
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	public String getQcontent() {
		return qcontent;
	}
	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}
	public String getAoption() {
		return aoption;
	}
	public void setAoption(String aoption) {
		this.aoption = aoption;
	}
	public String getBoption() {
		return boption;
	}
	public void setBoption(String boption) {
		this.boption = boption;
	}
	public String getCoption() {
		return coption;
	}
	public void setCoption(String coption) {
		this.coption = coption;
	}
	public String getDoption() {
		return doption;
	}
	public void setDoption(String doption) {
		this.doption = doption;
	}
	public String getQanswer() {
		return qanswer;
	}
	public void setQanswer(String qanswer) {
		this.qanswer = qanswer;
	}
	public String getQanalysis() {
		return qanalysis;
	}
	public void setQanalysis(String qanalysis) {
		this.qanalysis = qanalysis;
	}
	public String getOword() {
		return oword;
	}
	public void setOword(String oword) {
		this.oword = oword;
	}
	public String getQscope() {
		return qscope;
	}
	public void setQscope(String qscope) {
		this.qscope = qscope;
	}
	public String getQdifficulty() {
		return qdifficulty;
	}
	public void setQdifficulty(String qdifficulty) {
		this.qdifficulty = qdifficulty;
	}
	public long getQdate() {
		return qdate;
	}
	public void setQdate(long qdate) {
		this.qdate = qdate;
	}
	public QuestionType getQuestionType() {
		return questionType;
	}
	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
}
