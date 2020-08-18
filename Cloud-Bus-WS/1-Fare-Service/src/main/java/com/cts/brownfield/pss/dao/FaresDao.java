package com.cts.brownfield.pss.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.brownfield.pss.entity.Fares;

public interface FaresDao extends JpaRepository<Fares, Long>{
	

}
