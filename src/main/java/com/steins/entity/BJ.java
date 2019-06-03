package com.steins.entity;


import java.util.HashSet;
import java.util.Set;

/**
 * @author Sunny
 */
public class BJ {

	private Integer bjid;
	private String bjname;
	private Integer tid;
	private Teacher teacher;
	private Set<Students> students = new HashSet<Students>();
	
	public Set<Students> getStudents() {
		return students;
	}
	public void setStudents(Set<Students> students) {
		this.students = students;
	}
	public Integer getBjid() {
		return bjid;
	}
	public void setBjid(Integer bjid) {
		this.bjid = bjid;
	}
	public String getBjname() {
		return bjname;
	}
	public void setBjname(String bjname) {
		this.bjname = bjname;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
