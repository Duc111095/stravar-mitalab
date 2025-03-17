package com.ducnh.strava_mitalab.utils;

import java.util.ArrayList;
import java.util.List;

import com.ducnh.strava_mitalab.config.Messages;
import com.ducnh.strava_mitalab.config.StravaConfig;

public class PagingUtils {

		public static List<Paging> convertToStravaPaging(final Paging inputPaging){
			PagingUtils.validatePagingArgument(inputPaging);
			final List<Paging> stravaPaging = new ArrayList<Paging>();
			if (inputPaging == null) {
				stravaPaging.add(new Paging(Integer.valueOf(1), StravaConfig.DEFAULT_PAGE_SIZE));
				return stravaPaging;
			}
			if (inputPaging.getPage().intValue() == 0) {
				inputPaging.setPage(Integer.valueOf(1));
			}
			if (inputPaging.getPageSize().intValue() == 0) {
				inputPaging.setPageSize(StravaConfig.DEFAULT_PAGE_SIZE);
			}
			
			if (inputPaging.getPageSize().intValue() <= StravaConfig.MAX_PAGE_SIZE.intValue()) {
				stravaPaging.add(inputPaging);
				return stravaPaging;
			}
			
			// Calculate the first and last elements to be returned
			final int lastElement = (inputPaging.getPage().intValue() * inputPaging.getPageSize().intValue()) - inputPaging.getIgnoreLastN();
			final int firstElement = ((inputPaging.getPage().intValue() - 1) * inputPaging.getPageSize().intValue()) + inputPaging.getIgnoreFirstN() + 1;
			
			// If the last element fits in one page, return one page
		}
		public static void validatePagingArgument(final Paging pagingInstruction) {
			if (pagingInstruction == null) {
				return;
			}
			if (pagingInstruction.getPage().intValue() < 0) {
				throw new IllegalArgumentException(Messages.string("PagingUtils.pageArgumentTooLow"));
			}
			if (pagingInstruction.getPageSize().intValue() < 0) {
				throw new IllegalArgumentException(Messages.string("PagingUtils.perPagaArgumentTooLow"));
			}
			if((pagingInstruction.getIgnoreLastN() > 0) && (pagingInstruction.getIgnoreLastN() > pagingInstruction.getPageSize().intValue())) {
				throw new IllegalArgumentException(Messages.string("PagingUtils.IgnoreTooHigh"));
			}
			if((pagingInstruction.getIgnoreFirstN() > 0) && (pagingInstruction.getIgnoreFirstN() > pagingInstruction.getPageSize().intValue)) {
				throw new IllegalArgumentException(Messages.string("PagingUtils.IgnoreTooHigh"));
			}
		}
}
