package com.travelpackage;

import java.util.Scanner;

public class TravelAgencySystem {
	public static void main(String[] args) {
		TravelPackage travelPackage = new TravelPackage("Mountain Adventure", 50);
		Destination mountains = new Destination("Mountains");
		Activity hiking = new Activity("Hiking", 50.0, 20, "Enjoy hiking in the mountains", mountains);
		mountains.addActivity(hiking);
		travelPackage.addDestination(mountains);
		Passenger standardPassenger = new Passenger("John Doe", 1, PassengerType.STANDARD);
		Passenger goldPassenger = new Passenger("Jane Doe", 2, PassengerType.GOLD);
		travelPackage.addPassenger(standardPassenger);
		travelPackage.addPassenger(goldPassenger);

		// Print menu and get user choice
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\nMenu:");
			System.out.println("1. Print Itinerary");
			System.out.println("2. Print Passenger List");
			System.out.println("3. Print Passenger Details");
			System.out.println("4. Print Available Activities");
			System.out.println("5. Sign Up for Activity");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				travelPackage.printItinerary();
				break;
			case 2:
				travelPackage.printPassengerList();
				break;
			case 3:
				System.out.print("Enter passenger number: ");
				int passengerNumber = scanner.nextInt();
				travelPackage.printPassengerDetails(passengerNumber);
				break;
			case 4:
				travelPackage.printAvailableActivities();
				break;
			case 5:
				System.out.print("Enter passenger number: ");
				int signUpPassengerNumber = scanner.nextInt();
				System.out.print("Enter activity name: ");
				String activityName = scanner.next();
				System.out.print("Enter destination name: ");
				String destinationName = scanner.next();
				travelPackage.signUpForActivity(signUpPassengerNumber, activityName, destinationName);
				break;
			case 6:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		} while (choice != 6);
		scanner.close();
	}

}