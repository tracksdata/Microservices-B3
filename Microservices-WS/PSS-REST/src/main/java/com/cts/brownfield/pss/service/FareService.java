package com.cts.brownfield.pss.service;

import com.cts.brownfield.pss.entity.Fares;

public interface FareService {

	Fares updateNewFare(Fares fare);

	Fares getFareById(long id);

}