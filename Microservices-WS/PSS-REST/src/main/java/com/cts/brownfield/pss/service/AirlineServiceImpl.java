package com.cts.brownfield.pss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.brownfield.pss.dao.AirlineDao;
import com.cts.brownfield.pss.entity.AirlineInfo;

@Service
public class AirlineServiceImpl implements AirlineService {
	
	@Autowired
	private AirlineDao airlineDao;
	
	@Override
	public AirlineInfo findByNameOfAirline(String nameOfAirline) {
		return airlineDao.findByNameOfAirline(nameOfAirline);
	}
	
	@Override
	public List<AirlineInfo> findAllAirlines(){
		return airlineDao.findAll();
	}
	
	@Override
	public List<AirlineInfo> saveAirlines(List<AirlineInfo> airLines){
		return airlineDao.saveAll(airLines);
	}
	
	@Override
	public AirlineInfo saveAirLine(AirlineInfo airlineInfo) {
		return airlineDao.save(airlineInfo);
	}
	
	@Override
	public AirlineInfo findByAirlineId(long airlineId) {
		return airlineDao.findById(airlineId).orElse(null);
	}
	
	@Override
	public void deleteAirlineId(long airlineId) {
		airlineDao.deleteById(airlineId);
	}
	
	@Override
	public void deleteAirline(AirlineInfo airlineInfo) {
		airlineDao.delete(airlineInfo);
	}


}
