package com.ducnh.strava_mitalab.model;

import java.util.List;

import com.ducnh.strava_mitalab.model.reference.StravaResourceState;

public class StravaSegmentExplorerResponse implements StravaEntity{
	/**
	 * List of segments returned by the explorer
	 */
	private List<StravaSegmentExplorerResponseSegment> segments;

	/**
	 * No args constructor
	 */
	public StravaSegmentExplorerResponse() {
		super();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof StravaSegmentExplorerResponse)) {
			return false;
		}
		final StravaSegmentExplorerResponse other = (StravaSegmentExplorerResponse) obj;
		if (this.segments == null) {
			if (other.segments != null) {
				return false;
			}
		} else if (!this.segments.equals(other.segments)) {
			return false;
		}
		return true;
	}

	@Override
	public StravaResourceState getResourceState() {
		return StravaResourceState.DETAILED;
	}

	/**
	 * @return the segments
	 */
	public List<StravaSegmentExplorerResponseSegment> getSegments() {
		return this.segments;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.segments == null) ? 0 : this.segments.hashCode());
		return result;
	}

	/**
	 * @param segments
	 *            the segments to set
	 */
	public void setSegments(final List<StravaSegmentExplorerResponseSegment> segments) {
		this.segments = segments;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StravaSegmentExplorerResponse [segments=" + this.segments + "]"; //$NON-NLS-1$ //$NON-NLS-2$
	}
}
