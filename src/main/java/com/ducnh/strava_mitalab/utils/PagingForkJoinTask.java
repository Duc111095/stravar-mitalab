package com.ducnh.strava_mitalab.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

import com.ducnh.strava_mitalab.service.exception.BadRequestException;
import com.ducnh.strava_mitalab.service.exception.NotFoundException;

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
		
		if (this.pages.size() == 1) {
			try {
				final Paging pagingInstruction = this.pages.get(0);
				List<T> pageOfData = this.callback.getPageOfData(pagingInstruction);
				pageOfData = PagingUtils.ignoreLastN(pageOfData, pagingInstruction.getIgnoreLastN());
				pageOfData = PagingUtils.ignoreFirstN(pageOfData, pagingInstruction.getIgnoreFirstN());
				return pageOfData;
			} catch (NotFoundException e) {
				return null;
			} catch (BadRequestException e) {
				return null;
			}
		}
		
		final int middle = this.pages.size() / 2;
		final List<Paging> leftPages = this.pages.subList(0, middle);
		final PagingForkJoinTask<T> leftTask = new PagingForkJoinTask<T>(this.callback, leftPages);
		leftTask.join();
		
		final List<Paging> rightPages = this.pages.subList(middle, this.pages.size());
		final PagingForkJoinTask<T> rightTask = new PagingForkJoinTask<T>(this.callback, rightPages);
		final List<T> rightResult = rightTask.compute();
		
		final List<T> leftResult = leftTask.join();
		
		final List<T> result = new ArrayList<>();
		
		if ((leftResult == null) && (rightResult == null)) {
			return null;
		}
		if (leftResult != null) {
			result.addAll(leftResult);
		}
		if (rightResult != null) {
			result.addAll(rightResult);
		}
		
		return result;
	}

}
