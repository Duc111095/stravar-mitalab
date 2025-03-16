package com.ducnh.strava_mitalab.model.reference;

public interface StravaReferenceType<T> {
	public String getDescription();
	
	public T getId();
	
	public T getValue();
	
	@Override
	public String toString();
}
