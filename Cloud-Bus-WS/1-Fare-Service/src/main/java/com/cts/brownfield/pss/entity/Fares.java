package com.cts.brownfield.pss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "FARE")
@DynamicUpdate
public class Fares {
	@Id
	@GeneratedValue
	@Column(name = "fare_id")
	private long id;
	private double fare;
	private String currency;

	public Fares(double fare, String currency) {
		super();
		this.fare = fare;
		this.currency = currency;
	}

	public Fares() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Fares [id=" + id + ", fare=" + fare + ", currency=" + currency + "]";
	}

}
