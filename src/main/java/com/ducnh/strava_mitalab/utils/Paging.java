package com.ducnh.strava_mitalab.utils;

import com.ducnh.strava_mitalab.config.StravaConfig;

public class Paging {
	private static Integer validatePage(final Integer page) {
		if ((page == null) || (page.intValue() == 0)) {
			return Integer.valueOf(1);
		}
		return page;
	}
	
	private static Integer validatePageSize(final Integer pageSize) {
		if ((pageSize == null) || (pageSize.intValue() == 0)) {
			return StravaConfig.DEFAULT_PAGE_SIZE;
		}
		return pageSize;
	}
	
	private Integer page;
	
	private Integer pageSize;
	
	private int ignoreFirstN;
	
	private int ignoreLastN;
	
	public Paging() {
		this.page = Integer.valueOf(1);
		this.pageSize = StravaConfig.DEFAULT_PAGE_SIZE;
	}
	
	public Paging(final Integer page, final Integer pageSize) {
		this.page = page;
		this.pageSize = pageSize;
		this.ignoreFirstN = 0;
		this.ignoreLastN = 0;
	}
	
	public Paging(final Integer page, final Integer pageSize, final Integer ignoreFirstN, final Integer ignoreLastN) {
		this.page = page;
		this.pageSize = pageSize;
		this.ignoreFirstN = ignoreFirstN;
		this.ignoreLastN = ignoreLastN;
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		if (!(obj instanceof Paging) ) {
			return false;
		}
		
		Paging other = (Paging) obj;
		
		if (this.ignoreFirstN != other.ignoreFirstN) {
			return false;
		}
		
		if (this.ignoreLastN != other.ignoreLastN) {
			return false;
		}
		
		if (this.page == null) {
			if (other.page != null) {
				return false;
			}
		} else if (!(this.page.equals(other.page))) {
			return false;
		}
		
		if (this.pageSize == null) {
			if (other.pageSize != null) {
				return false;
			}
		} else if (!(this.pageSize.equals(other.pageSize))) {
			return false;
		}
		return true;
	}
	
	public int getIgnoreFirstN() {
		return this.ignoreFirstN;
	}
	
	public int getIgnoreLastN() {
		return this.ignoreLastN;
	}
	
	public Integer getPage() {
		return this.page;
	}
	
	public Integer getPageSize() {
		return this.pageSize;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + this.ignoreFirstN;
		result = (prime * result) + this.ignoreLastN;
		result = (prime * result) + ((this.page == null ? 0 : this.page.hashCode()));
		result = (prime * result) + ((this.pageSize == null ? 0 : this.pageSize.hashCode()));
		return result;
	}
	
	public void setIgnoreFirstN(final int ignoreFirstN) {
		this.ignoreFirstN = ignoreFirstN;
	}
	
	public void setIgnoreLastN(final int ignoreLastN) {
		this.ignoreLastN = ignoreLastN;
	}
	
	public void setPage(final Integer page) {
		this.page = page;
	}
	
	public void setPageSize(final Integer pageSize) {
		this.pageSize = pageSize;
	}
}


