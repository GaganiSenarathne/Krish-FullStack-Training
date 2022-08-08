package com.example.demo.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Schedule")
public class Schedule {
	
	@Id
	private long id;
	private LocalDateTime createdDate;
	private LocalDateTime sheduledDate;
	private String refID;
	private int shedID;
	
	public Schedule() {}

	public Schedule(long id, LocalDateTime createdDate, LocalDateTime sheduledDate, String refID, int shedID) {
		super();
		this.id = id;
		this.createdDate = createdDate;
		this.sheduledDate = sheduledDate;
		this.refID = refID;
		this.shedID = shedID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getSheduledDate() {
		return sheduledDate;
	}

	public void setSheduledDate(LocalDateTime sheduledDate) {
		this.sheduledDate = sheduledDate;
	}

	public String getRefID() {
		return refID;
	}

	public void setRefID(String refID) {
		this.refID = refID;
	}

	public int getShedID() {
		return shedID;
	}

	public void setShedID(int shedID) {
		this.shedID = shedID;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", createdDate=" + createdDate + ", sheduledDate=" + sheduledDate + ", refID="
				+ refID + ", shedID=" + shedID + "]";
	}
		

}