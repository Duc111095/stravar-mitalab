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
			if (lastElement <= StravaConfig.MAX_PAGE_SIZE.intValue()) {
				stravaPaging.add(new Paging(Integer.valueOf(1), Integer.valueOf(lastElement), inputPaging.getIgnoreFirstN(), 0));
				return stravaPaging;
			}
			
			// Otherwise, return a series of pages
			int currentPage = 0;
			for (int i = 1; i <= lastElement; i = i + StravaConfig.MAX_PAGE_SIZE.intValue()) {
				currentPage++;
				if (((currentPage * StravaConfig.MAX_PAGE_SIZE.intValue())) >= firstElement) {
					final int ignoreLastN = Math.max(0, (currentPage * StravaConfig.MAX_PAGE_SIZE.intValue()) - 1);
					final int ignoreFirstN = Math.max(0,  firstElement - ((currentPage - 1) * StravaConfig.MAX_PAGE_SIZE.intValue()) - 1);
					stravaPaging.add(new Paging(Integer.valueOf(currentPage), StravaConfig.MAX_PAGE_SIZE, ignoreFirstN, ignoreLastN));
				}
			}
			return stravaPaging;
		}
		
		public static <T> List<T> ignoreFirstN(final List<T> list, final int ignoreFirstN) {
			if (ignoreFirstN < 0) {
				throw new IllegalArgumentException(Messages.string("PagingUtils.cannotRemove") + ignoreFirstN + Messages.string("PagingUtils.itemsFromAList"));
			}
			if (list == null) {
				return null;
			}
			if (ignoreFirstN == 0) {
				return list;
			}
			if (ignoreFirstN >= list.size()) {
				return new ArrayList<T>();
			}
			
			// return list.subList(ignoreFirstN, list.size() - 1);
			final ArrayList<T> returnList = new ArrayList<T>();
			for (int i = ignoreFirstN; i < list.size(); i++) {
				returnList.add(list.get(i));
			}
			return returnList;
		}
		
		public static <T> List<T> ignoreLastN(final List<T> list, final int ignoreLastN) {
			if (ignoreLastN < 0) {
				throw new IllegalArgumentException(Messages.string("PagingUtils.cannotRemove") + ignoreLastN + Messages.string("PagingUtils.itemsFromAList"));
			}
			if (list == null) {
				return null;
			}
			if (ignoreLastN == 0) {
				return list;
			}
			return list.subList(0, list.size() - ignoreLastN);
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
			if((pagingInstruction.getIgnoreFirstN() > 0) && (pagingInstruction.getIgnoreFirstN() > pagingInstruction.getPageSize().intValue())) {
				throw new IllegalArgumentException(Messages.string("PagingUtils.IgnoreTooHigh"));
			}
		}
}
