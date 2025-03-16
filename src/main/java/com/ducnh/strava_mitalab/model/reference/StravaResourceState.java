package com.ducnh.strava_mitalab.model.reference;

import com.ducnh.strava_mitalab.config.Messages;
import com.ducnh.strava_mitalab.config.StravaConfig;

public enum StravaResourceState implements StravaReferenceType<Integer>{
	
	UPDATING(StravaConfig.integer("StravaResouceState.updating"), Messages.string("StravaResourceState.updating.description")),
	META(StravaConfig.integer("StravaResourceState.meta"), Messages.string("StravaResourceState.meta.description")),
	SUMMARY(StravaConfig.integer("StravaResourceState.summary"), Messages.string("StravaResourceState.summary.description")),
	DETAILED(StravaConfig.integer("StravaResourceState.detailed"), Messages.string("StravaResourceState.details")),
	PRIVATE(StravaConfig.integer("StravaResourceState.private"), Messages.string("StravaResourcesState.private.description")),
	UNKNOWN(StravaConfig.integer("Common.unknown.integer"), Messages.string("Common.unknown.description"));
	
	private Integer id;
	
	private String description;
	
	public static StravaResourceState create(final Integer id) {
		final StravaResourceState[] states = StravaResourceState.values();
		for (final StravaResourceState state : states) {
			if ((state.getValue() != null) && state.getValue().equals(id)) {
				return state;
			}
		}
		return StravaResourceState.UNKNOWN;
	}
	
	private StravaResourceState(final Integer id,final String description) {
		this.id = id;
		this.description = description;
	}
	
	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public Integer getValue() {
		return id;
	}
	
	@Override
	public String toString() {
		return this.id.toString();
	}

}
