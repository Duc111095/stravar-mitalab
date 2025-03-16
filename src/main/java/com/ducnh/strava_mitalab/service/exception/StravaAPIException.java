package com.ducnh.strava_mitalab.service.exception;

import com.ducnh.strava_mitalab.model.StravaResponse;

public interface StravaAPIException {
	public StravaResponse getResponse();
	
	public void setResponse(final StravaResponse response);
}
