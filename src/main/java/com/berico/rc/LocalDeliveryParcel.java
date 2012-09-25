package com.berico.rc;

public class LocalDeliveryParcel implements Parcel {

	private Parcel originalParcel = null;

	public LocalDeliveryParcel(Parcel originalParcel) {

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
	
	public void routeToPostOffice(){
		
		System.out.println(
			"Dropping package off in a mail box.");
	}

}
