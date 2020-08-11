package com.cts.brownfield.pss.service;

import java.util.List;

import com.cts.brownfield.pss.entity.AirlineInfo;

public interface AirlineService {

	AirlineInfo findByNameOfAirline(String nameOfAirline);

	List<AirlineInfo> findAllAirlines();

	List<AirlineInfo> saveAirlines(List<AirlineInfo> airLines);

	AirlineInfo saveAirLine(AirlineInfo airlineInfo);

	AirlineInfo findByAirlineId(long airlineId);

	void deleteAirlineId(long airlineId);

	void deleteAirline(AirlineInfo airlineInfo);

}