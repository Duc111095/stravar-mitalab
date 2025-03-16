package com.ducnh.strava_mitalab.cache;

import com.ducnh.strava_mitalab.model.StravaEntity;

public interface StravaCacheableEntity<U> extends StravaEntity {
	public U getId();
}
