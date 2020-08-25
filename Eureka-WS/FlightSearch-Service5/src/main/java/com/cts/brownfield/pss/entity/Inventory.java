package com.cts.brownfield.pss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Inventory {

	@Id
	@Column(name = "inv_id")
	@GeneratedValue
	long id;

	int count;

	public Inventory() {
		super();
	}

	public Inventory(int count) {
		super();
		this.count = count;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", count=" + count + "]";
	}

}
