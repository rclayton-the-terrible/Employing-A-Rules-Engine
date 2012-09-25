package com.berico.rc;

import java.util.Collection;

import org.drools.runtime.ObjectFilter;

import com.berico.BaseApp;

public class ResultCompilationApp extends BaseApp {

	@Override
	protected String getRuleFile() {
		
		return "ResultCompilation.drl";
	}

	
	public ResultCompilationApp() {
		super();
		
		// Create a bunch of parcels that need
		// to be routed.
		Parcel[] parcels = new Parcel[]{
			new BaseParcel(100, 90210),
			new BaseParcel(200, 90210),
			new BaseParcel(100, 20110),
			new BaseParcel(500, 87234),
			new BaseParcel(1000, 51234)
		};
		
		// Iterate over the parcels...
		for(Parcel parcel : parcels){
			
			// Inserting each parcel into the
			// rule session.
			getSession().insert(parcel);
		}
		
		// Apply all rules against the parcels
		getSession().fireAllRules();
		
		System.out.println("LOCAL DELIVERY PARCELS........");
		
		// Print the parcels that require Local Delivery
		printParcelInfo(LocalDeliveryParcel.class);
		
		System.out.println("TRAIN PARCELS........");
		
		// Print the parcels that require Train delivery
		printParcelInfo(TrainParcel.class);
		
		System.out.println("AIR MAIL PARCELS........");
		
		// Print the parcels that require Air Mail
		printParcelInfo(AirMailParcel.class);
		
		// Kill the session
		getSession().dispose();
	}
	
	/**
	 * Simple predicate to get all objects that match the
	 * supplied object type.
	 */
	public class ByClassTypeFilter implements ObjectFilter {

		private Class<?> targetClass = null;
		
		public ByClassTypeFilter(Class<?> targetClass){
			this.targetClass = targetClass;
		}
		
		@Override
		public boolean accept(Object object) {
			return object.getClass().equals(targetClass);
		}
	}
	
	/**
	 * Get the objects of the particular parcel type from
	 * the "Working Memory" of Drools and print them weight
	 * and destination zip code to the console.
	 * @param parcelClass Type of Parcel to retrieve
	 */
	protected void printParcelInfo(Class<? extends Parcel> parcelClass){
		
		// Pull the objects from the rule session,
		// by using a custom predicate that looks
		// for a specific Parcel implementation type.
		Collection<Object> oParcels 
			= getSession().getObjects(
				new ByClassTypeFilter(parcelClass));
	
		// Iterate over the matching objects...
		for(Object oParcel : oParcels){
			
			// Cast the object to the interface.
			Parcel parcel = (Parcel)oParcel;
			
			// Print the parcel information
			System.out.println(
				String.format("Weight: %s, Zip Code: %s", 
					parcel.getWeight(), 
					parcel.getDestinationZipCode()));
		}
	}
	
	public static void main(String[] args){
		
		new ResultCompilationApp();
	}
}
