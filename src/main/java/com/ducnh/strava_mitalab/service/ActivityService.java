package com.ducnh.strava_mitalab.service;

import java.util.concurrent.CompletableFuture;

import com.ducnh.strava_mitalab.model.StravaActivity;
import com.ducnh.strava_mitalab.model.StravaComment;
import com.ducnh.strava_mitalab.service.exception.BadRequestException;
import com.ducnh.strava_mitalab.service.exception.NotFoundException;

public interface ActivityService extends StravaService {
	public StravaComment createComment(final Long activityId, final String text) throws NotFoundException, BadRequestException;
	
	public StravaComment createComment(final String text) throws NotFoundException, BadRequestException;
	
	public CompletableFuture<StravaComment> createCommentAsync(final Long activityId, final String text) throws NotFoundException, BadRequestException;
	
	public StravaActivity createManualActivity(final StravaActivity activity);
	
	public CompletableFuture<StravaComment> createManualActivityAsync(final StravaActivity activity);
	
	public StravaActivity deleteActivity(final Long activityId) throws NotFoundException;
	
	public StravaActivity deleteActivity(final StravaActivity activity) throws NotFoundException;
	
	public CompletableFuture<StravaActivity> deleteActivityAsync(final Long activityId) throws NotFoundException;
	
	public void deleteComment(final Long activityId, final Integer commentId) throws NotFoundException;
	
	public void deleteComment(final StravaComment comment) throws NotFoundException;
	
	public CompletableFuture<Void> deleteCommentAsync(final Long activityId, final Integer commentId) throws NotFoundException;
	
	public CompletableFuture<Void> deleteCommentAsync(final StravaComment comment) throws NotFoundException;
	
	public StravaActivity getActivity(final Long activityId);
	
	public StravaActivity getActivity(final Long activityId, final Boolean includeAllEfforts);
	
	public CompletableFuture<StravaActivity> getActivityAsync(final Long activityId);
	
	public CompletableFuture<StravaActivity> getActivityAsync(final Long activityId, final Boolean includeAllEfforts);
	
}
