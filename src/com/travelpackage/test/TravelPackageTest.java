package com.travelpackage.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.travelpackage.Activity;
import com.travelpackage.Destination;
import com.travelpackage.Passenger;
import com.travelpackage.PassengerType;
import com.travelpackage.TravelPackage;

public class TravelPackageTest {

	private TravelPackage travelPackage;

	@Before
	public void setUp() {
		travelPackage = new TravelPackage("Mountain Adventure", 50);
		Destination mountains = new Destination("Mountains");
		Activity hiking = new Activity("Hiking", 50.0, 20, "Enjoy hiking in the mountains", mountains);
		mountains.addActivity(hiking);
		travelPackage.addDestination(mountains);
		Passenger standardPassenger = new Passenger("John Doe", 1, PassengerType.STANDARD);
		Passenger goldPassenger = new Passenger("Jane Doe", 2, PassengerType.GOLD);
		travelPackage.addPassenger(standardPassenger);
		travelPackage.addPassenger(goldPassenger);
	}

	@Test
	public void testAddDestination() {
		Destination newDestination = new Destination("Beach");
		travelPackage.addDestination(newDestination);
		assertTrue(travelPackage.getDestinations().contains(newDestination));
	}

	@Test
	public void testAddPassenger() {
		Passenger newPassenger = new Passenger("Alice", 3, PassengerType.STANDARD);
		travelPackage.addPassenger(newPassenger);
		assertTrue(travelPackage.getPassengers().contains(newPassenger));
	}

	@Test
	public void testSignUpForActivity() {
		Passenger passenger = travelPackage.findPassenger(1);
		assertNotNull(passenger);
		int initialCapacity = travelPackage.getDestinations().get(0).getActivities().get(0).getCapacity();
		travelPackage.signUpForActivity(1, "Hiking", "Mountains");
		assertEquals(initialCapacity - 1, travelPackage.getDestinations().get(0).getActivities().get(0).getCapacity());
		assertTrue(passenger.getActivities().stream().anyMatch(activity -> activity.getName().equals("Hiking")));
	}

	@Test
	public void testFindPassenger() {
		assertNotNull(travelPackage.findPassenger(1));
		assertNotNull(travelPackage.findPassenger(2));
		assertNull(travelPackage.findPassenger(3));
	}

	@Test
	public void testFindDestination() {
		assertNotNull(travelPackage.findDestination("Mountains"));
		assertNull(travelPackage.findDestination("Beach"));
	}

	@Test
	public void testFindActivity() {
		assertNotNull(travelPackage.findActivity(travelPackage.findDestination("Mountains"), "Hiking"));
		assertNull(travelPackage.findActivity(travelPackage.findDestination("Mountains"), "Sightseeing"));
	}
	
	
}
