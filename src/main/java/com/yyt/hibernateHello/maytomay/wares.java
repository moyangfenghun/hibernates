package com.yyt.hibernateHello.maytomay;

import java.util.HashSet;
import java.util.Set;

public class wares {
	public int waresId;
	public String name;
	public Set<itemize> itemizes=new HashSet<>();
	public wares() {
		// TODO Auto-generated constructor stub
	}
	public wares(int waresId, String name, Set<itemize> itemizes) {
		super();
		this.waresId = waresId;
		this.name = name;
		this.itemizes = itemizes;
	}
	public int getWaresId() {
		return waresId;
	}
	public String getName() {
		return name;
	}
	public Set<itemize> getItemizes() {
		return itemizes;
	}
	public void setWaresId(int waresId) {
		this.waresId = waresId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setItemizes(Set<itemize> itemizes) {
		this.itemizes = itemizes;
	}
	
}
