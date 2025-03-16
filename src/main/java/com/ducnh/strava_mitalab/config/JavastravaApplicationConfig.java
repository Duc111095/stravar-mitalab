package com.ducnh.strava_mitalab.config;

import java.util.ResourceBundle;

public class JavastravaApplicationConfig {

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("javastrava-application");
	
	private static final boolean STRAVA_ALLOWS_ACTIVITY_DELETE = Boolean.parseBoolean(RESOURCE_BUNDLE.getString("strava.permission.deleteActivity"));
	
	private static final boolean STRAVA_ALLOWS_COMMENTS_WRITE = Boolean.parseBoolean(RESOURCE_BUNDLE.getString("strava.permission.writeComment"));

	private static final boolean STRAVA_ALLOWS_GIVE_KUDOS = Boolean.parseBoolean(RESOURCE_BUNDLE.getString("strava.permission.giveKudos"));
	
	private static final boolean STRAVA_ALLOWS_WEBHOOKS_ENDPOINT = Boolean.parseBoolean(RESOURCE_BUNDLE.getString("strava.permission.webhooksEndpoint"));
	
	private static final boolean STRAVA_ALLOWS_CHALLENGES_ENDPOINT = Boolean.parseBoolean(RESOURCE_BUNDLE.getString("strava.permission.challengesEndpoint"));
	
	private static final boolean STRAVA_ALLOWS_BEACON_ENDPOINT = Boolean.parseBoolean(RESOURCE_BUNDLE.getString("strava.permission.beaconEndpoint"));
}
