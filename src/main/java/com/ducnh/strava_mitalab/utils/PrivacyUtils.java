package com.ducnh.strava_mitalab.utils;

import com.ducnh.strava_mitalab.model.StravaActivity;

public class PrivacyUtils {

	private static boolean activityBelongsToAuthenticatedUser(final StravaActivity activity, final Token token) {
		return activity.getAthlete().getId()activity.equals(token.getAt)
	}
}
