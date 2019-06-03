package com.steins.entity;

public class User {
	private Integer id;//id唯一标识
	private String username;//用户名
	private String password;//密码
	private String birth;//生日
	private Integer userIdentity;//身份1：管理员；0：普通用户
	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", birth='" + birth + '\'' +
				", userIdentity=" + userIdentity +
				'}';
	}
	
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getBirth() {
		return birth;
	}
	
	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	public Integer getUserIdentity() {
		return userIdentity;
	}
	
	public void setUserIdentity(Integer userIdentity) {
		this.userIdentity = userIdentity;
	}
}
