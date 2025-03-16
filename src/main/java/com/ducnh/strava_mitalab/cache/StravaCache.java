package com.ducnh.strava_mitalab.cache;

import java.util.List;

public interface StravaCache<T extends StravaCacheableEntity<U>, U> {
	public T get(U key);
	
	public List<T> list();
	
	public void put(T object);
	
	public void putAll(List<T> list);
	
	public void remove(U key);
	
	public void removeAll();
	
	public int size();
}
