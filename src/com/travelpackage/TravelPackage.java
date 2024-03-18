package com.travelpackage;

import java.util.ArrayList;

import java.util.List;

public class TravelPackage {
	private String name;
	private int passengerCapacity;
	private List<Destination> destinations;
	private List<Passenger> passengers;

	public TravelPackage(String name, int passengerCapacity) {
		this.name = name;
		this.passengerCapacity = passengerCapacity;
		this.destinations = new ArrayList<>();
		this.passengers = new ArrayList<>();
	}

	public void addDestination(Destination destination) {
		destinations.add(destination);
	}

	public void addPassenger(Passenger passenger) {
		passengers.add(passenger);
	}

	// Print the itinerary of the travel package
	public void printItinerary() {
		System.out.println("Travel Package: " + name);
		for (Destination destination : destinations) {
			System.out.println("Destination: " + destination.getName());
			for (Activity activity : destination.getActivities()) {
				System.out.println("Activity: " + activity.getName());
				System.out.println("Description: " + activity.getDescription());
				System.out.println("Cost: " + activity.getCost());
				System.out.println("Capacity: " + activity.getCapacity());
			}
		}
	}

	// Print the passenger list of the travel package
	public void printPassengerList() {
		System.out.println("Travel Package: " + name);
		System.out.println("Passenger Capacity: " + passengerCapacity);
		System.out.println("Number of Passengers Enrolled: " + passengers.size());
		for (Passenger passenger : passengers) {
			System.out.println("Passenger Name: " + passenger.getName());
			System.out.println("Passenger Number: " + passenger.getPassengerNumber());
		}
	}

	// Print the details of an individual passenger
	public void printPassengerDetails(int passengerNumber) {
		Passenger passenger = findPassenger(passengerNumber);
		if (passenger != null) {
			System.out.println("Passenger Name: " + passenger.getName());
			System.out.println("Passenger Number: " + passenger.getPassengerNumber());
			if (passenger.getType() == PassengerType.STANDARD || passenger.getType() == PassengerType.GOLD) {
				System.out.println("Balance: " + passenger.getBalance());
			}
			System.out.println("Activities Signed Up For:");
			for (Activity activity : passenger.getActivities()) {
				System.out.println("- " + activity.getName() + " at " + activity.getDestination().getName() + " for "
						+ activity.getCost());
			}
		} else {
			System.out.println("Passenger not found.");
		}
	}

	public void signUpForActivity(int passengerNumber, String activityName, String destinationName) {
		Passenger passenger = findPassenger(passengerNumber);
		if (passenger != null) {
			Destination destination = findDestination(destinationName);
			if (destination != null) {
				Activity activity = findActivity(destination, activityName);
				if (activity != null && activity.getCapacity() > 0) {
					passenger.signUpForActivity(activity);
					System.out.println(passenger.getName() + " signed up for " + activity.getName() + " at "
							+ destination.getName());
				} else {
					System.out.println("Activity not found or no available spaces.");
				}
			} else {
				System.out.println("Destination not found.");
			}
		} else {
			System.out.println("Passenger not found.");
		}
	}

	// Helper method to find a destination by its name
	public Destination findDestination(String destinationName) {
		for (Destination destination : destinations) {
			if (destination.getName().equalsIgnoreCase(destinationName)) {
				return destination;
			}
		}
		return null;
	}

	// Helper method to find an activity by its name within a destination
	public Activity findActivity(Destination destination, String activityName) {
		for (Activity activity : destination.getActivities()) {
			if (activity.getName().equalsIgnoreCase(activityName)) {
				return activity;
			}
		}
		return null;
	}

	// Print the details of all activities with available spaces
	public void printAvailableActivities() {
		System.out.println("Activities with Available Spaces:");
		for (Destination destination : destinations) {
			for (Activity activity : destination.getActivities()) {
				if (activity.getCapacity() > 0) {
					System.out.println("Destination: " + destination.getName());
					System.out
							.println("- " + activity.getName() + " (" + activity.getCapacity() + " spaces available)");
				}
			}
		}
	}

	// Helper method to find a passenger by their number
	public Passenger findPassenger(int passengerNumber) {
		for (Passenger passenger : passengers) {
			if (passenger.getPassengerNumber() == passengerNumber) {
				return passenger;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	public List<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	// Other getters and setters
}