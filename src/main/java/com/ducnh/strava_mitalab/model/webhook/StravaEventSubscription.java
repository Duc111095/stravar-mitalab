package com.ducnh.strava_mitalab.model.webhook;

import java.time.ZonedDateTime;

import com.ducnh.strava_mitalab.model.StravaEntity;
import com.ducnh.strava_mitalab.model.reference.StravaResourceState;
import com.ducnh.strava_mitalab.model.webhook.reference.StravaSubscriptionAspectType;
import com.ducnh.strava_mitalab.model.webhook.reference.StravaSubscriptionObjectType;
import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class StravaEventSubscription implements StravaEntity{
	private Integer id;
	private Integer applicationId;
	
	@SerializedName("object_type_id")
	private StravaSubscriptionObjectType objectType;
	
	@SerializedName("aspect_type_id")
	private StravaSubscriptionAspectType aspectType;
	
	@SerializedName("callback_url")
	private String callbackURL;
	
	private ZonedDateTime createdAt;
	
	private ZonedDateTime updatedAt;
	
	public StravaEventSubscription() {}
	
	@Override
	public StravaResourceState getResourceState() {
		return StravaResourceState.DETAILED;
	}
	
	@Override
	public String toString() {
		return "StravaEventSubscription [id" + this.id + ", applicationId=" + this.applicationId + ", objectType="
				+ this.objectType + ", aspectType=" + this.aspectType + ", callbackURL=" + this.callbackURL + ", createdAt="
				+ this.createdAt + ", updatedAt=" + this.updatedAt + "]";
	}
}	
