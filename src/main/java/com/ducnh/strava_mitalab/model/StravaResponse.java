package com.ducnh.strava_mitalab.model;

import java.util.List;

import com.ducnh.strava_mitalab.model.reference.StravaResourceState;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class StravaResponse implements StravaEntity {
	private String message;
	private List<StravaAPIError> errors;
	public StravaResponse() {
		super();
	}
	
	@Override
	public StravaResourceState getResourceState() {
		return StravaResourceState.DETAILED;
	}
	
	@Override
	public String toString() {
		return "StravaResponse [message=" + this.message + ", errors=" + this.errors + "]";
	}
}
