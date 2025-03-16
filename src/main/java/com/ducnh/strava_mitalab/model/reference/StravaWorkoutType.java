package com.ducnh.strava_mitalab.model.reference;

import com.ducnh.strava_mitalab.config.Messages;
import com.ducnh.strava_mitalab.config.StravaConfig;

public enum StravaWorkoutType implements StravaReferenceType<Integer> {

	DEFAULT_RUN(StravaConfig.integer("StravaWorkoutType.defaultRun"), Messages.string("StravaWorkoutType.defaultRun.description")),
	RACE_RUN(StravaConfig.integer("StravaWorkoutType.raceRun"), Messages.string("StravaWorkoutType.raceRun.description")),
	LONG_RUN(StravaConfig.integer("StravaWorkoutType.longRun"), Messages.string("StravaWorkoutType.longRun.description")),
	WORKOUT_RUN(StravaConfig.integer("StravaWorkoutType.workoutRun"), Messages.string("StravaWorkoutType.workoutRun.description")),
	DEFAULT_RIDE(StravaConfig.integer("StravaWorkoutType.defaultRide"), Messages.string("StravaWorkoutType.defaultRide.description")),
	RACE_RIDE(StravaConfig.integer("StravaWorkoutType.raceRide"), Messages.string("StravaWorkoutType.raceRide.description")),
	WORKOUT_RIDE(StravaConfig.integer("StravaWorkoutType.workoutRide"), Messages.string("StravaWorkoutType.workoutType.description")),
	UNKNOWN(StravaConfig.integer("Common.unknown.integer"), Messages.string("Common.unknown.description"));
	
	private Integer id;
	private String description;
	
	private StravaWorkoutType(final Integer id, final String description) {
		this.id = id;
		this.description = description;
	}
	
	@Override
	public String getDescription() {
		return this.description;
	}
	
	@Override
	public Integer getId() {
		return this.id;
	}
	
	@Override
	public Integer getValue() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return this.id.toString();
	}
 	
	public static StravaWorkoutType create(final Integer id) {
		final StravaWorkoutType[] workoutTypes = StravaWorkoutType.values();
		for (final StravaWorkoutType workoutType : workoutTypes) {
			if (workoutType.getId().equals(id)) {
				return workoutType;
			}
		}
		return StravaWorkoutType.UNKNOWN;
 	}
	
	
}
