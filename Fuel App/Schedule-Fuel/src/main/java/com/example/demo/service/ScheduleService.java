package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.Schedule;


public interface ScheduleService {
	
	public Schedule saveSchedule(Schedule schedule);
	public Schedule getOrderDetails(String fuelType, int fuelCapacity, String refId, int shedID);
	ResponseEntity<List<Schedule>> getAllScheduledOrders();

}
