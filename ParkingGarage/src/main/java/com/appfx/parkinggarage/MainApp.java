package com.appfx.parkinggarage;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainApp {

	public static void main(String[] args) {

		// Parking Garage with 3 floors and 10 spaces per floor
		
		ParkingGarage parkingGarage = new ParkingGarage(3, 10);
		
		// Vehicles 
		AbstractVehicle car1 = new Car("K-AA1101");
		AbstractVehicle car2 = new Car("B-AL1234");
		AbstractVehicle moto1 = new Motorcycle("moto-198");
		AbstractVehicle moto2 = new Motorcycle("moto-271");
		
		// Parken
		
		parkingGarage.parkVehicle(car1);
		parkingGarage.parkVehicle(car2);
		parkingGarage.parkVehicle(moto1);
		parkingGarage.parkVehicle(moto2);
		
		// print status
		parkingGarage.printStatus();
		
		// search for a vehicle
		String targetId = car1.getId();
		Optional<AbstractVehicle> foundVehicle = parkingGarage.findVehicleByIdWithAnonymousClass(targetId);
		foundVehicle.ifPresent(v -> System.out.println("Found vehicle with ID " + targetId + ": " + v));
		
		// remove a vehicle
		parkingGarage.removeVehicle("B-AL1234");
		parkingGarage.printStatus();
		
		// Find all motorcycle using lambda
		System.out.println("\n--- All Motorcycle in the Parking Garage ---");
		
		List<AbstractVehicle> motorcycles  = parkingGarage.floors.stream()
				.flatMap(floor -> floor.getSpaces().stream())
				.filter(ParkingSpace::isOccupied)
				.map(ParkingSpace::getVehicle)
				.filter(v -> v instanceof Motorcycle)
				.collect(Collectors.toList());
		
		motorcycles.forEach(System.out::println);
		//motorcycles.forEach(mo -> System.out.println(mo));

	}

}
