package com.ducnh.strava_mitalab.service.exception;

import com.ducnh.strava_mitalab.model.StravaResponse;

public class BadRequestException extends RuntimeException implements StravaAPIException {
	private static final long serialVersionUID = 1L;
	
	private StravaResponse response;
	
	public BadRequestException (final String status, final StravaResponse response, final Throwable cause) {
		super(status + " : " + (response == null ? "" : response.toString()), cause);
		this.response = response;
	}
	
	@Override
	public StravaResponse getResponse() {
		return this.response;
	}

	@Override
	public void setResponse(StravaResponse response) {
		this.response = response;
	}

}
