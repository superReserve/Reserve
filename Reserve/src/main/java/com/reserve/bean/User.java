package com.reserve.bean;

public class User {
	private int accId; // 用户ID
	private String username; // 用户名
	private String password; // 密码
	private String fullname; // 全称
	private int age; // 年龄
	private String address; // 家庭住址
	private String createdTime; // 创建时间
	private String locked; // 锁住状态

	public User(int accId, String username, String password, String fullname,
			int age, String address, String createdTime, String locked) {
		super();
		this.accId = accId;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.age = age;
		this.address = address;
		this.createdTime = createdTime;
		this.locked = locked;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getLocked() {
		return locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}

}
