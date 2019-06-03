package com.steins.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class QuestionPaper {
	private Integer qpid;
	private long qpdate;
	private Integer time;
	private Teacher teacher; 

	private Set<QpRelationq> qpRelationq = new HashSet<QpRelationq>();
	private Set<TestControl> testControl = new HashSet<TestControl>();
	private Set<TestNote> testNote = new HashSet<TestNote>();

	@Override
	public String toString() {
		return "QuestionPaper{" +
				"qpid=" + qpid +
				", qpdate=" + qpdate +
				", time=" + time +
				", teacher=" + teacher +
				", qpRelationq=" + qpRelationq +
				", testControl=" + testControl +
				", testNote=" + testNote +
				'}';
	}

	public Set<TestNote> getTestNote() {
		return testNote;
	}
	public void setTestNote(Set<TestNote> testNote) {
		this.testNote = testNote;
	}
	public Set<TestControl> getTestControl() {
		return testControl;
	}
	public void setTestControl(Set<TestControl> testControl) {
		this.testControl = testControl;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public Integer getQpid() {
		return qpid;
	}
	public void setQpid(Integer qpid) {
		this.qpid = qpid;
	}
	public long getQpdate() {
		return qpdate;
	}
	public void setQpdate(long qpdate) {
		this.qpdate = qpdate;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	
	public Set<QpRelationq> getQpRelationq() {
		return qpRelationq;
	}
	public void setQpRelationq(Set<QpRelationq> qpRelationq) {
		this.qpRelationq = qpRelationq;
	}
	
}
