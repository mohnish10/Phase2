package com.flyaway.model;

public class Flight {
	private int id;
	private int sourceId;
	private int destinationId;
	private int airlineId;
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Flight(int sourceId, int destinationId, int airlineId, double price) {
		super();
		this.sourceId = sourceId;
		this.destinationId = destinationId;
		this.airlineId = airlineId;
		this.price = price;
	}
	private double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}
	public int getDestinationId() {
		return destinationId;
	}
	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}
	public int getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Flight [id=" + id + ", sourceId=" + sourceId + ", destinationId=" + destinationId + ", airlineId="
				+ airlineId + ", price=" + price + "]";
	}
}