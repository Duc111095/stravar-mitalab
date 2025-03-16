package com.ducnh.strava_mitalab.model.reference;

import com.ducnh.strava_mitalab.config.Messages;
import com.ducnh.strava_mitalab.config.StravaConfig;

public enum StravaActivityType implements StravaReferenceType<String>{
	
	RIDE(StravaConfig.string("StravaActivityType.ride"), Messages.string("StravaActivityType.ride.description")), //$NON-NLS-1$ //$NON-NLS-2$
	RUN(StravaConfig.string("StravaActivityType.run"), Messages.string("StravaActivityType.run.description")), //$NON-NLS-1$ //$NON-NLS-2$
	SWIM(StravaConfig.string("StravaActivityType.swim"), Messages.string("StravaActivityType.swim.description")), //$NON-NLS-1$ //$NON-NLS-2$
	HIKE(StravaConfig.string("StravaActivityType.hike"), Messages.string("StravaActivityType.hike.description")), //$NON-NLS-1$ //$NON-NLS-2$	
	WALK(StravaConfig.string("StravaActivityType.walk"), Messages.string("StravaActivityType.walk.description")), //$NON-NLS-1$ //$NON-NLS-2$
	ALPINE_SKI(StravaConfig.string("StravaActivityType.alpineski"), //$NON-NLS-1$
			Messages.string("StravaActivityType.alpineski.description")), //$NON-NLS-1$
	BACKCOUNTRY_SKI(StravaConfig.string("StravaActivityType.backcountryski"), //$NON-NLS-1$
			Messages.string("StravaActivityType.backcountryski.description")), //$NON-NLS-1$
	CANOEING(StravaConfig.string("StravaActivityType.canoeing"), //$NON-NLS-1$
			Messages.string("StravaActivityType.canoeing.description")), //$NON-NLS-1$
	CROSSFIT(StravaConfig.string("StravaActivityType.crossfit"), //$NON-NLS-1$
			Messages.string("StravaActivityType.crossfit.description")), //$NON-NLS-1$
	EBIKE_RIDE(StravaConfig.string("StravaActivityType.ebikeride"), //$NON-NLS-1$
			Messages.string("StravaActivityType.ebikeride.description")), //$NON-NLS-1$
	ELLIPTICAL(StravaConfig.string("StravaActivityType.elliptical"), //$NON-NLS-1$
			Messages.string("StravaActivityType.elliptical.description")), //$NON-NLS-1$
	ICE_SKATE(StravaConfig.string("StravaActivityType.iceskate"), //$NON-NLS-1$
			Messages.string("StravaActivityType.iceskate.description")), //$NON-NLS-1$
	INLINE_SKATE(StravaConfig.string("StravaActivityType.inlineskate"), //$NON-NLS-1$
			Messages.string("StravaActivityType.inlineskate.description")), //$NON-NLS-1$
	KAYAKING(StravaConfig.string("StravaActivityType.kayaking"), //$NON-NLS-1$
			Messages.string("StravaActivityType.kayaking.description")), //$NON-NLS-1$
	KITESURF(StravaConfig.string("StravaActivityType.kitesurf"), //$NON-NLS-1$
			Messages.string("StravaActivityType.kitesurf.description")), //$NON-NLS-1$
	NORDIC_SKI(StravaConfig.string("StravaActivityType.nordicski"), //$NON-NLS-1$
			Messages.string("StravaActivityType.nordicski.description")), //$NON-NLS-1$
	ROCK_CLIMBING(StravaConfig.string("StravaActivityType.rockclimbing"), //$NON-NLS-1$
			Messages.string("StravaActivityType.rockclimbing.description")), //$NON-NLS-1$
	ROLLERSKI(StravaConfig.string("StravaActivityType.rollerski"), //$NON-NLS-1$
			Messages.string("StravaActivityType.rollerski.description")), //$NON-NLS-1$
	ROWING(StravaConfig.string("StravaActivityType.rowing"), Messages.string("StravaActivityType.rowing.description")), //$NON-NLS-1$ //$NON-NLS-2$
	SNOWBOARD(StravaConfig.string("StravaActivityType.snowboard"), //$NON-NLS-1$
			Messages.string("StravaActivityType.snowboard.description")), //$NON-NLS-1$
	SNOWSHOE(StravaConfig.string("StravaActivityType.snowshoe"), //$NON-NLS-1$
			Messages.string("StravaActivityType.snowshoe.description")), //$NON-NLS-1$
	STAIR_STEPPER(StravaConfig.string("StravaActivityType.stairstepper"), //$NON-NLS-1$
			Messages.string("StravaActivityType.stairstepper.description")), //$NON-NLS-1$
	STAND_UP_PADDLING(StravaConfig.string("StravaActivityType.standuppaddling"), //$NON-NLS-1$
			Messages.string("StravaActivityType.standuppaddling.description")), //$NON-NLS-1$
	SURFING(StravaConfig.string("StravaActivityType.surfing"), //$NON-NLS-1$
			Messages.string("StravaActivityType.surfing.description")), //$NON-NLS-1$
	VIRTUAL_RIDE(StravaConfig.string("StravaActivityType.virtualride"), //$NON-NLS-1$
			Messages.string("StravaActivityType.virtualride.description")), //$NON-NLS-1$
	WEIGHT_TRAINING(StravaConfig.string("StravaActivityType.weighttraining"), //$NON-NLS-1$
			Messages.string("StravaActivityType.weighttraining.description")), //$NON-NLS-1$
	WINDSURF(StravaConfig.string("StravaActivityType.windsurf"), //$NON-NLS-1$
			Messages.string("StravaActivityType.windsurf.description")), //$NON-NLS-1$
	WORKOUT(StravaConfig.string("StravaActivityType.workout"), //$NON-NLS-1$
			Messages.string("StravaActivityType.workout.description")), //$NON-NLS-1$
	YOGA(StravaConfig.string("StravaActivityType.yoga"), Messages.string("StravaActivityType.yoga.description")), //$NON-NLS-1$ //$NON-NLS-2$
	UNKNOWN(StravaConfig.string("Common.unknown"), Messages.string("Common.unknown.description")); //$NON-NLS-1$ //$NON-NLS-2$;

	private String id;
	private String description;
	
	private StravaActivityType(final String id, final String description) {
		this.id = id;
		this.description = description;
	}
	
	public static StravaActivityType create(final String id) {
		for (final StravaActivityType type : StravaActivityType.values()) {
			if (type.getId().equalsIgnoreCase(id)) {
				return type;
			}
		}
		return UNKNOWN;
	}
	
	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getValue() {
		return this.id;
	}

	@Override
	public String toString() {
		return this.id;
	}
}
