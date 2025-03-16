package com.ducnh.strava_mitalab.model.reference;

import com.ducnh.strava_mitalab.config.Messages;
import com.ducnh.strava_mitalab.config.StravaConfig;

public enum StravaActivityZoneType implements StravaReferenceType<String> {
	HEARTRATE(StravaConfig.string("StravaActivityZoneType.heartrate"), Messages.string("StravaActivityZoneType.heartrate.description")),
	POWER(StravaConfig.string("StravaActivityZoneType.power"), Messages.string("StravaActivityZoneType.power.description")),
	UNKNOWN(StravaConfig.string("Common.unknown"), Messages.string("Common.unknown.description"));
	
	private String id;
	private String description;
	
	private StravaActivityZoneType(final String id, final String description) {
		this.id = id;
		this.description = description;
	}
	
	public static StravaActivityZoneType create(final String id) {
		final StravaActivityZoneType[] types = StravaActivityZoneType.values();
		for (final StravaActivityZoneType type : types) {
			if (type.getId().equals(id)) {
				return type;
			}
		}
		return UNKNOWN;
	}
	
	@Override
	public String getDescription() {
		return this.description;
	}
	
	@Override
	public String getId() {
		return this.id;
	}
	
	@Override
	public String getValue() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return this.id;
	}
}
