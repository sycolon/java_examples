package com.appfx.parkinggarage;

class Car extends AbstractVehicle{
	
	public Car(String licensePlate) {
		super(licensePlate);
	}

	@Override
	public String getType() {
		return "Car";
	}

}
