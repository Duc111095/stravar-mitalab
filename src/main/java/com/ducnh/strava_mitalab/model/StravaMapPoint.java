package com.ducnh.strava_mitalab.model;

import com.ducnh.strava_mitalab.model.reference.StravaResourceState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class StravaMapPoint implements StravaEntity{
	private Float latitude;
	private Float longitude;
	
	public StravaMapPoint() {
		super();
	}
	
	@Override
	public StravaResourceState getResourceState() {
		return StravaResourceState.DETAILED;
	}

	@Override
	public String toString() {
		return "StravaMapPoint [latitude=" + this.latitude + ", longitude=" + this.longitude + "]";
	}
}
