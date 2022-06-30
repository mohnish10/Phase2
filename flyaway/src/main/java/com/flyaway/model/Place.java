package com.flyaway.model;

public class Place {
	private int id;
	private String pname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "Place [id=" + id + ", pname=" + pname + "]";
	}
	public Place(String pname) {
		super();
		this.pname = pname;
	}
	public Place() {
		super();
		// TODO Auto-generated constructor stub
	}
}