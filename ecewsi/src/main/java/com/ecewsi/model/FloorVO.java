package com.ecewsi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="floor_master")
public class FloorVO {
		
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="floor")
	private String floor;
	
	@Column(name="floorDiscription")
	private String floorDiscription;
	
	@Column(name="status")
	private boolean status= true;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getFloorDiscription() {
		return floorDiscription;
	}

	public void setFloorDiscription(String floorDiscription) {
		this.floorDiscription = floorDiscription;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	

	
}
