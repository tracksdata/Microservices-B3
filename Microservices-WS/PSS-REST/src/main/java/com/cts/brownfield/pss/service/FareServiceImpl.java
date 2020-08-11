package com.cts.brownfield.pss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.brownfield.pss.dao.FareDao;
import com.cts.brownfield.pss.entity.Fares;

@Service
public class FareServiceImpl implements FareService {
	
	@Autowired
	private FareDao fareDao;
	
	@Override
	public Fares updateNewFare(Fares fare) {
		return fareDao.save(fare);
	}
	
	@Override
	public Fares getFareById(long id) {
		return fareDao.findById(id).orElse(null);
	}
	

}
