package com.yyt.hibernateHello.onetoone;

public class Person {
	public int id;
	public String name;
	public String age;
	public int height;
	public Jacket jacket;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	public Person(int id, String name, String age, int height, Jacket jacket) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.height = height;
		this.jacket = jacket;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAge() {
		return age;
	}
	public int getHeight() {
		return height;
	}
	public Jacket getJacket() {
		return jacket;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setJacket(Jacket jacket) {
		this.jacket = jacket;
	}
}
