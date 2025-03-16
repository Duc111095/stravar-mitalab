package com.ducnh.strava_mitalab.service.exception;

import com.ducnh.strava_mitalab.model.StravaResponse;

public class NotFoundException extends RuntimeException implements StravaAPIException {
	private static final long serialVersionUID = 1L;
	
	private StravaResponse response;
	
	public NotFoundException(final StravaResponse response, final Throwable cause) {
		super((response == null ? null : response.toString()), cause);
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
