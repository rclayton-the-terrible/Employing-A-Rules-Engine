package com.berico.ra;

import com.berico.BaseApp;

public class RequestAdjudicationApp extends BaseApp {

	@Override
	protected String getRuleFile() {
		
		return "RequestAdjudication.drl";
	}

	public RequestAdjudicationApp(){
		super();
		
		// Create a case that should be deemed "guilty".
		SpeedingTicketCase maryCase = new SpeedingTicketCase("Audi", 1);
		
		// Insert object into session.
		getSession().insert(maryCase);
		
		// Create a case that should be deemed "innocent".
		SpeedingTicketCase richardCase = new SpeedingTicketCase("Honda", 35);
		
		// Insert object into session.
		getSession().insert(richardCase);
		
		// Evaluate the rules against our objects.
		getSession().fireAllRules();
		
		// Dispose the rule session.
		getSession().dispose();
		
		// Print the results of the verdict for Mary
		System.out.println(
			String.format("Is Mary guilty?: %s", maryCase.isGuilty()));
		
		// Print the results of the verdict for Richard
		System.out.println(
			String.format("Is Richard guilty?: %s", richardCase.isGuilty()));
	}
	
	public static void main(String[] args){
		
		new RequestAdjudicationApp();
	}
}
