package com.berico.rc;

public class TrainParcel implements Parcel {
	
	private Parcel originalParcel = null;

	public TrainParcel(Parcel originalParcel) {

		this.originalParcel = originalParcel;
	}

	public Parcel getOriginalParcel() {
		return originalParcel;
	}

	@Override
	public double getWeight() {
		
		return originalParcel.getWeight();
	}

	@Override
	public int getDestinationZipCode() {
		
		return originalParcel.getDestinationZipCode();
	}
	
	public void routeToFreightCar(){
		
		System.out.println(
			"Giving package to hobo, destination: Akron, OH.");
	}
}
