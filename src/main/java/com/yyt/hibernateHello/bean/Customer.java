package com.yyt.hibernateHello.bean;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	public Integer id;
	public String name;
	
	public Set<Order> order=new HashSet<>();
	
	
	public Customer() {
		
	}
	
	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}

	public Customer(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
}
