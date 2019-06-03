package com.steins.entity;

/**
 * @author Sunny
 */
public class QpRelationq {
	private Integer rid;	//�Ծ��������Ӧ��ϵid
	private Integer num;	//�Ծ�����������
	//�Ծ��������
	private QuestionPaper questionPaper;
	//�����������
	private Question question;
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public QuestionPaper getQuestionPaper() {
		return questionPaper;
	}
	public void setQuestionPaper(QuestionPaper questionPaper) {
		this.questionPaper = questionPaper;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
}
