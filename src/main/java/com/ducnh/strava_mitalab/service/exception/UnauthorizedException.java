package com.ducnh.strava_mitalab.service.exception;

import com.ducnh.strava_mitalab.model.StravaResponse;

public class UnauthorizedException extends RuntimeException implements StravaAPIException {
	private static final long serialVersionUID = 1L;
	
	private StravaResponse response;
	
	public UnauthorizedException(final String status, final StravaResponse response, final Throwable cause) {
		super(status + " : " + (response == null ? "" : response.toString()), cause);
		this.response = response;
	}
	
	@Override
	public StravaResponse getResponse() {
		return this.response;
	}
	
	@Override
	public void setResponse(final StravaResponse response) {
		this.response = response;
	}
}
