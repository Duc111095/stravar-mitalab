package com.ducnh.strava_mitalab.model;

import com.ducnh.strava_mitalab.model.reference.StravaResourceState;

public class StravaAchievement implements StravaEntity {
	private Integer typeId;
	private String type;
	private Integer rank;
	public StravaAchievement() {
		super();
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof StravaAchievement)) {
			return false;
		}
		final StravaAchievement other = (StravaAchievement) obj;
		if (this.rank == null) {
			if (other.rank != null) {
				return false;
			}
		} else if (!this.rank.equals(other.rank)) {
			return false;
		}
		if (this.type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!this.type.equals(other.type)) {
			return false;
		}
		if (this.typeId == null) {
			if (other.typeId != null) {
				return false;
			}
		} else if (!this.typeId.equals(other.typeId)) {
			return false;
		}
		return true;
	}
	
	public Integer getRank() {
		return rank;
	}
	
	public String getType() {
		return type;
	}
	
	public Integer getTypeId() {
		return typeId;
	}	
	
	@Override
	public StravaResourceState getResourceState() {
		return StravaResourceState.DETAILED;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.rank == null) ? 0 : this.getRank().hashCode());
		result = (prime * result) + ((this.type == null) ? 0 : this.getType().hashCode());
		result = (prime * result) + ((this.typeId == null) ? 0 : this.getTypeId().hashCode());
		return result;
	}
	
	public void setRank(final Integer rank) {
		this.rank = rank;
	}
	
	public void setType(final String type) {
		this.type = type;
	}
	
	public void setTypeId(final Integer typeId) {
		this.typeId = typeId;
	}
	
	@Override
	public String toString() {
		return "StravaAchievement [typeId=" + this.typeId + ", type=" + this.type + ", rank=" + this.rank + "]";
	}
}
