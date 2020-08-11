package com.cts.brownfield.pss.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.brownfield.pss.entity.AirlineInfo;

public interface AirlineDao extends JpaRepository<AirlineInfo, Long> {
	
	
	AirlineInfo findByNameOfAirline(String nameOfAirline);

}
