package com.berico.ra;

public class SpeedingTicketCase {

	private boolean isGuilty;
	
	private String vehicleMake = null;
	
	private int mphOverSpeedLimit = -1;

	public SpeedingTicketCase( 
			String vehicleMake,
			int mphOverSpeedLimit) {

		this.vehicleMake = vehicleMake;
		this.mphOverSpeedLimit = mphOverSpeedLimit;
	}

	public boolean isGuilty() {
		return isGuilty;
	}
	
	public void adjudicate(boolean isGuilty){
		this.isGuilty = isGuilty;
	}

	public String getVehicleMake() {
		return vehicleMake;
	}

	public int getMphOverSpeedLimit() {
		return mphOverSpeedLimit;
	}
}
