package fuelApp.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

public class Order {
	
	@Id 
	private long id;
	private String RefId;
	private String shedName;
	private int shedId;
	private String location;
	private int capacity;
	private String fuelType;
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dateTime;
	private String status = "Pending...";
	
	
	public Order() {}

	public Order(long id, String refId, String shedName, int shedId, String location, int capacity, String fuelType,
			LocalDateTime dateTime, String status) {
		super();
		this.id = id;
		RefId = refId;
		this.shedName = shedName;
		this.shedId = shedId;
		this.location = location;
		this.capacity = capacity;
		this.fuelType = fuelType;
		this.dateTime = dateTime;
		this.status = status;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRefId() {
		return RefId;
	}
	public void setRefId(String refId) {
		RefId = refId;
	}
	public String getShedName() {
		return shedName;
	}
	public void setShedName(String shedName) {
		this.shedName = shedName;
	}
	public int getShedId() {
		return shedId;
	}
	public void setShedId(int shedId) {
		this.shedId = shedId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", RefId=" + RefId + ", shedName=" + shedName + ", shedId=" + shedId + ", location="
				+ location + ", capacity=" + capacity + ", fuelType=" + fuelType + ", dateTime=" + dateTime
				+ ", status=" + status + "]";
	}

	
}