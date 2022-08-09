package com.example.demo.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public class Dispatch {
	
	@Id
	private long id;
	private String refID;
	private String status;
	private LocalDateTime dispatchedDate;
	private int capacity;
	private String fuelType;
	
	public Dispatch() {	}

	public Dispatch(long id, String refID, String status, LocalDateTime dispatchedDate, int capacity, String fuelType) {
		super();
		this.id = id;
		this.refID = refID;
		this.status = status;
		this.dispatchedDate = dispatchedDate;
		this.capacity = capacity;
		this.fuelType = fuelType;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRefID() {
		return refID;
	}

	public void setRefID(String refID) {
		this.refID = refID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getDispatchedDate() {
		return dispatchedDate;
	}

	public void setDispatchedDate(LocalDateTime dispatchedDate) {
		this.dispatchedDate = dispatchedDate;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return "Dispatch [id=" + id + ", refID=" + refID + ", status=" + status + ", dispatchedDate=" + dispatchedDate
				+ ", capacity=" + capacity + ", fuelType=" + fuelType + "]";
	}
	

}
