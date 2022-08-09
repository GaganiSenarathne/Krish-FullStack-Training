package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Schedule;
import com.example.demo.service.ScheduleService;

@RestController
@RequestMapping("/Schedule")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ScheduleController {
	
	@Autowired
	ScheduleService scheduleService;
	
	@PostMapping
	public Schedule saveAvailableFuel(@RequestBody Schedule schedule) {
		return scheduleService.saveSchedule(schedule);
	}
	
	@GetMapping
	public ResponseEntity<List<Schedule>> getAllOrders(){
		return scheduleService.getAllScheduledOrders();
	}
	

}
