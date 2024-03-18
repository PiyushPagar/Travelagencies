package com.travelpackage;

//Activity class
public class Activity {
	private String name;
	private double cost;
	private int capacity;
	private String description;
	private Destination destination;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Activity(String name, double cost, int capacity, String description, Destination destination) {
		this.name = name;
		this.cost = cost;
		this.capacity = capacity;
		this.description = description;
		this.destination = destination;
	}

	public double getCost() {
		return cost;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	// Other getters and setters
}