package com.travelpackage;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
	private String name;
	private int passengerNumber;
	private PassengerType type;
	private double balance;
	private List<Activity> activities;

	public Passenger(String name, int passengerNumber, PassengerType type) {
		this.name = name;
		this.passengerNumber = passengerNumber;
		this.type = type;
		this.activities = new ArrayList<>();
		this.balance = type == PassengerType.PREMIUM ? 0 : 100; // Initial balance for standard and gold passengers
	}

	public void signUpForActivity(Activity activity) {
		if (activity.getCapacity() > 0) {
			if (type == PassengerType.PREMIUM || balance >= activity.getCost()) {
				if (type == PassengerType.GOLD) {
					balance -= activity.getCost() * 0.9; // Apply 10% discount for gold passengers
				} else if (type == PassengerType.STANDARD) {
					balance -= activity.getCost();
				}
				activities.add(activity);
				activity.setCapacity(activity.getCapacity() - 1);
			} else {
				System.out.println("Insufficient balance for passenger: " + name);
			}
		} else {
			System.out.println("Activity is full: " + activity.getName());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPassengerNumber() {
		return passengerNumber;
	}

	public void setPassengerNumber(int passengerNumber) {
		this.passengerNumber = passengerNumber;
	}

	public PassengerType getType() {
		return type;
	}

	public void setType(PassengerType type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	// Other getters and setters

}