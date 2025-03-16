package com.ducnh.strava_mitalab.model;

import com.ducnh.strava_mitalab.model.reference.StravaResourceState;

public class StravaAPIError implements StravaEntity{
	
	private String resource;
	private String field;
	private String code;
	
	public StravaAPIError() {
		super();
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		
		if (!(obj instanceof StravaAPIError)) return false;
		
		final StravaAPIError other = (StravaAPIError) obj;
		
		if (this.code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!this.code.equals(other.code)) {
			return false;
		}
		
		if (this.field == null) {
			if (other.field != null) {
				return false;
			}
		} else if (!this.field.equals(other.field)) {
			return false;
		}
		
		if (this.resource == null) {
			if (other.resource != null) {
				return false;
			}
		} else if (!this.resource.equals(other.resource)) {
			return false;
		}
		return true;
	}
	
	public void setCode(final String code) {
		this.code = code;
	}
	
	public void setField(final String field) {
		this.field = field;
	}
	
	public void setResource(final String resource) {
		this.resource = resource;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public String getField() {
		return this.field;
	}
	
	public String getResource() {
		return this.resource;
	}
	
	@Override
	public StravaResourceState getResourceState() {
		return StravaResourceState.DETAILED;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.code == null) ? 0 : this.code.hashCode());
		result = (prime * result) + ((this.field == null) ? 0 : this.field.hashCode());
		result = (prime * result) + ((this.resource == null) ? 0 : this.resource.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "StravaAPIError [resource=" + this.resource + ", field=" + this.field + ", code=" + this.code + "]";
	}
}
