package com.ducnh.strava_mitalab.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import com.ducnh.strava_mitalab.config.StravaConfig;
import com.ducnh.strava_mitalab.service.exception.BadRequestException;
import com.ducnh.strava_mitalab.service.exception.NotFoundException;
import com.ducnh.strava_mitalab.service.exception.UnauthorizedException;

public class PagingHandler {
	private static ForkJoinPool pool = new ForkJoinPool();

	public static <T> List<T> handleListAll(final PagingCallback<T> callback) {
		return handleListAll(callback, StravaConfig.PAGING_LIST_ALL_PARALLELISM);
	}
	
	public static <T> List<T> handleListAll(final PagingCallback<T> callback, final int parallelism) {
		int parallelismUsed = parallelism;
		if (parallelismUsed == 0) {
			parallelismUsed = StravaConfig.PAGING_LIST_ALL_PARALLELISM;
		}
		boolean loop = true;
		final List<T> records = new ArrayList<T>();
		int page = 0;
		final Integer pageSize = Integer.valueOf(StravaConfig.MAX_PAGE_SIZE.intValue() * parallelismUsed);
		
		while (loop) {
			page++;
			List<T> currentPage;
			try {
				currentPage = handlePaging(new Paging(Integer.valueOf(page), pageSize), callback);
			} catch (NotFoundException e) {
				return null;
			} catch (BadRequestException e) {
				return null;
			} catch (UnauthorizedException e) {
				return null;
			}
			if (currentPage == null) {
				return null;
			}
			records.addAll(currentPage);
			if (currentPage.size() < pageSize.intValue()) {
				loop = false;
			}
		}
		return records;
	} 
	
	public static <T> List<T> handlePaging(final Paging pagingInstruction, final PagingCallback<T> callback) {
		PagingUtils.validatePagingArgument(pagingInstruction);
		List<T> records = new ArrayList<>();
		try {
			final List<Paging> pages = PagingUtils.convertToStravaPaging(pagingInstruction);
			
			if (pages.size() == 1) {
				final Paging paging = pages.get(0);
				records = callback.getPageOfData(paging);
				records = PagingUtils.ignoreFirstN(records, paging.getIgnoreFirstN());
				records = PagingUtils.ignoreLastN(records, paging.getIgnoreLastN());
				return records;
			}
			
			records = pool.invoke(new PagingForkJoinTask<T>(callback, pages));
		} catch (NotFoundException e) {
			return null;
		} catch (UnauthorizedException e) {
			return new ArrayList<T>();
		} catch (BadRequestException e) {
			return new ArrayList<T>();
		}
		return records;
	}
}
