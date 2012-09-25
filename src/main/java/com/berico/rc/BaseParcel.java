package com.berico.rc;

public class BaseParcel implements Parcel {

	private double weight = -1;
	
	private int destinationZipCode = -1;

	public BaseParcel(double weight, int destinationZipCode) {
		this.weight = weight;
		this.destinationZipCode = destinationZipCode;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public int getDestinationZipCode() {
		return destinationZipCode;
	}
}
