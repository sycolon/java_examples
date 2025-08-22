package com.appfx.parkinggarage;

class Motorcycle extends AbstractVehicle {

	public Motorcycle(String licensePlate) {
		super(licensePlate);
	}

	@Override
	public String getType() {
		
		return "Motorcycle";
	}
}
