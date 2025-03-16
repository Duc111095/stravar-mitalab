package com.ducnh.strava_mitalab.cache.impl;

import com.ducnh.strava_mitalab.cache.StravaCache;
import com.ducnh.strava_mitalab.cache.StravaCacheableEntity;

public class StravaCacheImpl<T extends StravaCacheableEntity<U>, U> implements StravaCache<T, U>{
	private final Token token;
	
	private final GroupCacheAccess<StravaCacheKey<U, T>>
}
