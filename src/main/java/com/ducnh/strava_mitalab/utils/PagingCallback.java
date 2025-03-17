package com.ducnh.strava_mitalab.utils;

import java.util.List;

import com.ducnh.strava_mitalab.service.exception.BadRequestException;
import com.ducnh.strava_mitalab.service.exception.NotFoundException;

public interface PagingCallback<T>{
	public List<T> getPageOfData(final Paging thisPage) throws NotFoundException, BadRequestException;
}
