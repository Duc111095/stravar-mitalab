package com.ducnh.strava_mitalab.utils;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class PagingForkJoinTask<T> extends RecursiveTask<List<T>> {
	public static final long serialVersionUID = 1L;
	
	private final PagingCallback<T> callback;
	
	private final List<Paging> pages;
	
	public PagingForkJoinTask(final PagingCallback<T> callback, final List<Paging> pages) {
		this.callback = callback;
		this.pages = pages;
	}
	
	@Override
	protected List<T> compute() {
		if (this.pages.size() == 0) {
			return null;
		}
	}

}
