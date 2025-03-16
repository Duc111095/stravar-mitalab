package com.ducnh.strava_mitalab.config;

import java.util.ResourceBundle;

public class Messages {

	private static final String BUNDLE_NAME = "javastrava-messages";
	
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	
	public static String string(final String key) {
		return RESOURCE_BUNDLE.getString(key);
	}
	
	private Messages() {
	}
}
