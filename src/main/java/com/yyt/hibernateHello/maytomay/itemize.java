package com.yyt.hibernateHello.maytomay;

import java.util.HashSet;
import java.util.Set;

public class itemize {
	public int itemId;
	public String name;
	public Set<wares> wares=new HashSet<>();
	public itemize() {
		// TODO Auto-generated constructor stub
	}
	public itemize(int itemId, String name, Set<com.yyt.hibernateHello.maytomay.wares> wares) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.wares = wares;
	}
	public int getItemId() {
		return itemId;
	}
	public String getName() {
		return name;
	}
	public Set<wares> getWares() {
		return wares;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setWares(Set<wares> wares) {
		this.wares = wares;
	}
	
}
