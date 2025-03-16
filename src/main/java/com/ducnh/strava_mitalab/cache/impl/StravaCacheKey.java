package com.ducnh.strava_mitalab.cache.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class StravaCacheKey<T, U> {

	private T id;
	private Token token;
	private Class<U> class1;
	
	public StravaCacheKey<final T id, final Token token, final Class<U> class1> {
		super();
		this.id = id;
		this.token = token;
		this.class1 = class1;
	}
	
	@Override
	public String toString() {
		return "StravaCacheKey [id=" + this.id + ", token=" + this.token + ", class1=" + this.class1 + "]";
	}
}
