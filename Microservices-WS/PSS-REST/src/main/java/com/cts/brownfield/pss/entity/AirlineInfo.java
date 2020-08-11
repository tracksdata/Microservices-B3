package com.cts.brownfield.pss.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.cts.brownfield.pss.dao.FlightInfo;

@Entity
public class AirlineInfo {

	@Id
	@GeneratedValue
	private long airlineId;
	private String nameOfAirline;
	private String airlineLogo;

	public AirlineInfo() {
		// TODO Auto-generated constructor stub
	}

	public AirlineInfo(String nameOfAirline,String airlineLogo) {
		this.nameOfAirline = nameOfAirline;
		this.airlineLogo = airlineLogo;
	}
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "flightsInfo",joinColumns = {@JoinColumn(name="airlineId")},inverseJoinColumns = {@JoinColumn(name="flightInfoid")})
	private List<FlightInfo> info=new ArrayList<>();

	
	
	public List<FlightInfo> getInfo() {
		return info;
	}

	public void setInfo(List<FlightInfo> info) {
		this.info = info;
	}

	public long getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(long airlineId) {
		this.airlineId = airlineId;
	}

	public String getNameOfAirline() {
		return nameOfAirline;
	}

	public void setNameOfAirline(String nameOfAirline) {
		this.nameOfAirline = nameOfAirline;
	}

	
	public String getAirlineLogo() {
		return airlineLogo;
	}

	public void setAirlineLogo(String airlineLogo) {
		this.airlineLogo = airlineLogo;
	}

}
