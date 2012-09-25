package com.berico.da;

import com.berico.BaseApp;

public class DirectActionApp extends BaseApp {

	@Override
	protected String getRuleFile() {
		
		return "DirectAction.drl";
	}

	public DirectActionApp(){
		super();
		
		// Instantiate the email service.
		EmailService emailService = new EmailPrinter();
		
		// Register the service on the session as a global.
		getSession().setGlobal("emailService", emailService);
		
		// Create a report that should not fire rule.
		TPSReport michaelTpsReport 
			= new TPSReport(true, "Michael Bolton");
		
		// Insert object into session.
		getSession().insert(michaelTpsReport);
		
		// Create a report that should fire rule.
		TPSReport peterTpsReport 
			= new TPSReport(false, "Peter Gibbons");
		
		// Insert object into session.
		getSession().insert(peterTpsReport);
		
		// Evaluate the rules against our objects.
		getSession().fireAllRules();
		
		// Dispose the rule session.
		getSession().dispose();
	}
	
	public static void main(String[] args){
		
		new DirectActionApp();
	}
}
