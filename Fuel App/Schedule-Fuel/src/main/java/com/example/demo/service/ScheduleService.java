package com.example.demo.service;

import com.example.demo.model.Schedule;


public interface ScheduleService {
	
	public Schedule saveSchedule(Schedule schedule);
	public Schedule getOrderDetails(String fuelType, int fuelCapacity, String refId, int shedID);

}