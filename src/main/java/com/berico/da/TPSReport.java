package com.berico.da;

public class TPSReport {

	protected boolean hasCoverSheet = false;
	
	protected String author = null;

	public TPSReport(
		boolean hasCoverSheet, String author) {

		this.hasCoverSheet = hasCoverSheet;
		this.author = author;
	}

	public boolean isHasCoverSheet() {
		return hasCoverSheet;
	}

	public String getAuthor() {
		return author;
	}
	
}