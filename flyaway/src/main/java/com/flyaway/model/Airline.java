package com.flyaway.model;

public class Airline {
	private int id;
	private String aname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Airline() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Airline(String aname) {
		super();
		this.aname = aname;
	}
	@Override
	public String toString() {
		return "Airline [id=" + id + ", aname=" + aname + "]";
	}
}