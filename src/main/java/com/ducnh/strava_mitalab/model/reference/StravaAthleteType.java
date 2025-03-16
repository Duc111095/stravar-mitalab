package com.ducnh.strava_mitalab.model.reference;

import com.ducnh.strava_mitalab.config.Messages;
import com.ducnh.strava_mitalab.config.StravaConfig;

public enum StravaAthleteType implements StravaReferenceType<Integer> {
	CYCLIST(StravaConfig.integer("StravaAthleteType.cyclist"), Messages.string("StravaAthleteType.cyclist.description")),
	RUNNER(StravaConfig.integer("StravaAthleteType.runner"), Messages.string("StravaAthleteType.runner.description")),
	UNKNOWN(StravaConfig.integer("Common.unknown.integer"), Messages.string("Common.unknown.description"));		

	private Integer id;
	private String description;
	
	private StravaAthleteType(final Integer id, final String description) {
		this.id = id;
		this.description = description;
	}
	
	public static StravaAthleteType create(final Integer id) {
		final StravaAthleteType[] categories = StravaAthleteType.values();
		for (final StravaAthleteType category : categories) {
			if (category.getId().equals(id)) {
				return category;
			}
		}
		return StravaAthleteType.UNKNOWN;
	}
	
	@Override
	public Integer getId() {
		return this.id;
	}
	
	@Override
	public String getDescription() {
		return this.description;
	}
	
	@Override
	public Integer getValue() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return this.id.toString();
	}
	
}
