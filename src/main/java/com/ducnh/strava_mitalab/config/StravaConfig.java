package com.ducnh.strava_mitalab.config;

import java.util.ResourceBundle;

public class StravaConfig {

	private static final String BUNDLE_NAME = "javastrava-config";
	
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	public static final Integer DEFAULT_PAGE_SIZE = integer("strava.defaut_page_size");
	
	public static final Integer MAX_PAGE_SIZE = integer("strava.max_page_size");
	
	public static final String ENDPOINT = string("strava.endpoint");
	
	public static final String AUTH_ENDPOINT = string("strava.auth.endpoint");
	
	public static final String SESSION_COOKIE_NAME = string("strava.session_cookie");
	
	public static final String DATE_FORMAT = string("strava.date_format");
	
	public static final int WARN_AT_REQUEST_LIMIT_PERCENT = integer("strava.warn_at_request_limit_percent").intValue();
	
	public static final int PAGING_LIST_ALL_PARALLELISM = integer("strava.paging_list_all_parallelism").intValue();
	
	public static Integer integer(final String key) {
		return Integer.valueOf(RESOURCE_BUNDLE.getString(key));
	}
	
	public static String string(final String property) {
		return RESOURCE_BUNDLE.getString(property);
	}
}
