package com.berico.da;

public interface EmailService {

	void email(
		String to, String from, String subject, String message);
	
}
