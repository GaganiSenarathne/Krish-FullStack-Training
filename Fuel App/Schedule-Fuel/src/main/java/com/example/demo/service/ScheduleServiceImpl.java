package com.example.demo.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.kafkaConfig.KafkaTopic;
import com.example.demo.model.Schedule;
import com.example.demo.repository.ScheduleRepository;


@Service
public class ScheduleServiceImpl implements ScheduleService{

	@Autowired
	ScheduleRepository repository;
	
	@Autowired
	KafkaTemplate<String, Schedule> kafkaTemplate;
	
	
	@Override
	public Schedule saveSchedule(Schedule schedule) {
		
		return repository.save(schedule);
	}

	@Override
	public Schedule getOrderDetails(String fuelType, int fuelCapacity, String refId, int shedID) {

		Schedule schedule = new Schedule();
		
//		Random date - next 5 to 10 days
		LocalDateTime localDateTime = LocalDateTime.now();
		Random random = new Random();
        int randomAmountOfDays = random.nextInt(10 - 5 + 1) + 5;        
        LocalDateTime futureLocalDateTime = localDateTime.plusDays(
                randomAmountOfDays);
		
		long id = Instant.now().getEpochSecond();
		schedule.setId(id);
		schedule.setRefID(refId);
		schedule.setCreatedDate(localDateTime);
		schedule.setShedID(shedID);
		schedule.setSheduledDate(futureLocalDateTime);
		
		saveSchedule(schedule);
		kafkaTemplate.send(KafkaTopic.MESSAGE_TOPIC, schedule);
		
		return schedule;
	}
	
	@Override
	public ResponseEntity<List<Schedule>> getAllScheduledOrders() {
		
//		Getting all the orders
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
	}

}
