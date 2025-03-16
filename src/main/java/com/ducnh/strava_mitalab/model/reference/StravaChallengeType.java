package com.ducnh.strava_mitalab.model.reference;

import com.ducnh.strava_mitalab.config.Messages;
import com.ducnh.strava_mitalab.config.StravaConfig;

public enum StravaChallengeType implements StravaReferenceType<String>{
	
	CUMULATIVE_CHALLENGE(StravaConfig.string("StravaChallengeType.cumulative"), Messages.string("StravaChallengeType.cummulative.description")),
	SEGMENT_CHALLENGE(StravaConfig.string("StravaChallengeType.segment"), Messages.string("StravaChallengeType.segment.description")),
	SINGLE_ACTIVITY_CHALLENGE(StravaConfig.string("StravaChallengeType.singleActivity"), Messages.string("StravaChallengeType.singleActivity.description")),
	UNKNOWN(StravaConfig.string("Common.unknown"), Messages.string("Common.unknown.description"));
	
	private String id;
	private String description;
	private StravaChallengeType(final String id, final String description) {
		this.id = id;
		this.description = description;
	}
	
	public static StravaChallengeType create(final String id) {
		for (final StravaChallengeType type : StravaChallengeType.values()) {
			if (type.getId().equals(id)) {
				return type;
			}
		}
		return UNKNOWN;
	}
	
	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public String getValue() {
		return id;
	}
	
	@Override
	public String toString() {
		return this.id;
	}
}
