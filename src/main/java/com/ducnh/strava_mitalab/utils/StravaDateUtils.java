package com.ducnh.strava_mitalab.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class StravaDateUtils {
	public static Integer secondsSinceUnixEpoch(final LocalDateTime date) {
		if (date == null) {
			return null;
		}
		final Long timeInSeconds = Long.valueOf(date.toEpochSecond(ZoneOffset.UTC));
		return Integer.valueOf(timeInSeconds.intValue());
	}
}
