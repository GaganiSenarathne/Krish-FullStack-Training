package com.example.demo.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "InventoryReserved")
public class InventoryReserved {
	
	@Id
	private long id;
	private String refID;
	private String fuelType;
	private int shedID;
	private int qty;
	private LocalDateTime dateTime;
	
	public InventoryReserved() {}

	public InventoryReserved(long id, String refID, String fuelType, int shedID, int qty, LocalDateTime dateTime) {
		super();
		this.id = id;
		this.refID = refID;
		this.fuelType = fuelType;
		this.shedID = shedID;
		this.qty = qty;
		this.dateTime = dateTime;
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

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getShedID() {
		return shedID;
	}

	public void setShedID(int shedID) {
		this.shedID = shedID;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "InventoryReserved [id=" + id + ", refID=" + refID + ", fuelType=" + fuelType + ", shedID=" + shedID
				+ ", qty=" + qty + ", dateTime=" + dateTime + "]";
	}
	
	
}
