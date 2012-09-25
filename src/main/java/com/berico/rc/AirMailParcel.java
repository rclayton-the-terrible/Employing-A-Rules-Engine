package com.berico.rc;

public class AirMailParcel implements Parcel {

	private Parcel originalParcel = null;

	public AirMailParcel(Parcel originalParcel) {

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
	
	public void routeToPlane(){
		
		System.out.println(
			"Attaching package to underside of biplane.");
	}

}
