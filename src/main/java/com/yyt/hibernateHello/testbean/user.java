package com.yyt.hibernateHello.testbean;

import java.util.Date;

public class user {
	public Integer id;
	public String name;
	public Integer age;
	public String sex;
	public Date createDate;
	
	public user() {
		
	}
	
	
	public user(Integer id, String name) {
		this.id = id;
		this.name = name;
	}


	public user(Integer id, String name, Integer age, String sex,Date createDate) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.createDate=createDate;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Integer getAge() {
		return age;
	}
	public String getSex() {
		return sex;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", createDate=" + createDate
				+ "]";
	}
	
	
}
