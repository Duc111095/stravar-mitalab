package com.ducnh.strava_mitalab.model.reference;

import com.ducnh.strava_mitalab.config.Messages;
import com.ducnh.strava_mitalab.config.StravaConfig;

public enum StravaAgeGroup implements StravaReferenceType<String> {
	AGE0_24(StravaConfig.string("StravaAgeGroup.0-24"), Messages.string("StravaAgeGroup.0-24.description")),
	AGE25_34(StravaConfig.string("StravaAgeGroup.25-34"), Messages.string("StravaAgeGroup.25-34.description")),
	AGE35_44(StravaConfig.string("StravaAgeGroup.35-44"), Messages.string("StravaAgeGroup.35-44.description")),
	AGE45_54(StravaConfig.string("StravaAgeGroup.45-54"), Messages.string("StravaAgeGroup.45-54.description")),
	AGE55_64(StravaConfig.string("StravaAgeGroup.55-64"), Messages.string("StravaAgeGroup.55-64.description")),
	AGE65_PLUS(StravaConfig.string("StravaAgeGroup.65plus"), Messages.string("StravaAgeGroup.65plus.description")),
	UNKNOWN(StravaConfig.string("Common.unknown"), Messages.string("Common.unknown.description"));
	
	private String id;
	private String description;
	
	private StravaAgeGroup(final String id, final String description) {
		this.id = id;
		this.description = description;
	}
	
	public static StravaAgeGroup create(final String id) {
		final StravaAgeGroup[] ageGroups = StravaAgeGroup.values();
		for (final StravaAgeGroup group : ageGroups) {
			if (group.getId().equals(id)) {
				return group;
			}
		}
		return StravaAgeGroup.UNKNOWN;
	}
	
	@Override
	public String getId() {
		return this.id;
	}
	
	@Override
	public String getDescription() {
		return this.description;
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
