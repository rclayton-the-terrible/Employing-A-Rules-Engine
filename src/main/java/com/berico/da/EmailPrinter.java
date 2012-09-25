package com.berico.da;

public class EmailPrinter implements EmailService {

	@Override
	public void email(
			String to, String from, String subject, String message) {
		
		System.out.println(
			String.format(
				"To: %s \nFrom: %s \nSubject: %s\n----------------------\n%s", 
				to, from, subject, message));
	}

}
