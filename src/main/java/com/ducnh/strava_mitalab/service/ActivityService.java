package com.ducnh.strava_mitalab.service;

public interface ActivityService extends StravaService {
	public StravaComment createComment(final Long activityId, final String text) throws NotFoundException, BadRequestException;
}
