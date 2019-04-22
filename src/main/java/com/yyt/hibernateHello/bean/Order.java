package com.yyt.hibernateHello.bean;

public class Order {
	public int id;
	public double money;
	public int goodsid;
	public Customer customer;
	public Order() {
	}
	
	public Order(int id, double money, int goodsid, Customer customer) {
		super();
		this.id = id;
		this.money = money;
		this.goodsid = goodsid;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}
	public double getMoney() {
		return money;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
