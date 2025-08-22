package com.appfx.parkinggarage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

class ParkingGarage {

	final List<Floor> floors;
	private final int totalFloors;
	private final int spacesPerFloor;
    private String statusString;
	
	public ParkingGarage(int totalFloors, int spacesPerFloor) {
		this.totalFloors = totalFloors;
		this.spacesPerFloor = spacesPerFloor;
		
		this.floors = new ArrayList<>();
		for(int i = 0 ; i<totalFloors; i++) {
			floors.add(new Floor(i+1, spacesPerFloor));
		}
	}
	
	// Finds and parks a vehicle in the first available space.
	
	public boolean parkVehicle(AbstractVehicle vehicle) {
		
		Optional<ParkingSpace> vacantSpace = floors.stream()
				.flatMap(floor -> floor.getSpaces().stream())
				.filter(space -> !space.isOccupied())
				.findFirst();
		
		if(vacantSpace.isPresent()) {
			vacantSpace.get().parkVehicle(vehicle);
			System.out.println("Vehicle: " + vehicle.getLicensePlate() + " Parked Successfully.");
			return true;
		}else {
			System.out.println("No vacant space available for vehicle " + vehicle.getLicensePlate());
			return false;
		}
	}
	
	public boolean removeVehicle(String licensePlate) {
		
		Optional<ParkingSpace> occupiedSpace = floors.stream()
				.flatMap(floor -> floor.getSpaces().stream())
				.filter(space -> space.isOccupied() && space.getVehicle().getLicensePlate().equals(licensePlate))
				.findFirst();
		
		if(occupiedSpace.isPresent()) {
			AbstractVehicle vehicle = occupiedSpace.get().removeVehicle();
			System.out.println("Vehicle "+ vehicle.getLicensePlate() + " removed successfully.");
			return true;
		}else {
			System.out.println("Vehicle with license plate " + licensePlate + " not found.");
			return false;
		}
	}
	
	public void printStatus() {
		System.out.println("------ Parking Garage Status ------");
		floors.forEach(floor -> {
			System.out.println("Floor " + floor.getFloorNumber() + ":");
			floor.getSpaces().forEach(space -> {
				System.out.println(space);
			});
		});
		System.out.println("----------------------------------");
	}

    public String getStatus() {
        //StringBuilder
        statusString = "";
        statusString+="------ Parking Garage Status ------\n";
        floors.forEach(floor -> {
            statusString+="Floor"+ floor.getFloorNumber() +":\n";
            floor.getSpaces().forEach(space -> {
                statusString+=space+"\n";
            });
        });
        statusString+="----------------------------------\n";
        return statusString;
    }
	
	// Find a vehicle 'vehicleId' (anonymous class)
	
	public Optional<AbstractVehicle> findVehicleByIdWithAnonymousClass(String vehicleId){
		
		Predicate<AbstractVehicle> isTargetVehicle = new Predicate<AbstractVehicle>() {
			
			@Override
			public boolean test(AbstractVehicle vehicle) {
				return vehicle.getId().equals(vehicleId);
			}
		};
		
		return floors.stream()
				.flatMap(floor -> floor.getSpaces().stream())
				.filter(ParkingSpace::isOccupied)  //(p -> p.isOccupied()) Methodenreferenz
				.map(ParkingSpace::getVehicle) //(p -> p.getVehicle())
				.filter(isTargetVehicle)
				.findFirst();
	}
	
}
