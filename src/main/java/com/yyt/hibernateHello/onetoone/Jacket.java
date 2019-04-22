package com.yyt.hibernateHello.onetoone;

public class Jacket {
	public int id;
	public String size;
	public String colour;
	public Person person;
	public Jacket() {
		// TODO Auto-generated constructor stub
	}
	public Jacket(int id, String size, String colour, Person person) {
		super();
		this.id = id;
		this.size = size;
		this.colour = colour;
		this.person = person;
	}
	public int getId() {
		return id;
	}
	public String getSize() {
		return size;
	}
	public String getColour() {
		return colour;
	}
	public Person getPerson() {
		return person;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
