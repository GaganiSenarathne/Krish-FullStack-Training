package com.example.demo.service;

import java.time.Instant;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.kafkaConfig.KafkaTopic;
import com.example.demo.model.Dispatch;
import com.example.demo.repository.DispatchRepository;
import com.example.demo.repository.OrderRepository;

import fuelApp.model.Order;


@Service
public class DispatchServiceImpl implements DispatchService{

	@Autowired
	DispatchRepository dispatchRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	KafkaTemplate<String, Dispatch> kafkaTemplate;
	
	@Override
	public ResponseEntity<Dispatch> saveSchedule(Dispatch dispatch) {
		
		kafkaTemplate.send(KafkaTopic.MESSAGE_TOPIC, dispatch);		
//		return dispatchRepository.save(dispatch);
		return ResponseEntity.status(HttpStatus.OK).body(getFuelDetails(dispatch));
	}
	
	public Dispatch getFuelDetails(Dispatch dispatch){
		
		Order order = orderRepository.findByRefId(dispatch.getRefID());
		
//		System.out.println(order);
		
		int capacity = order.getCapacity();
		String fuelType = order.getFuelType();
		long id = Instant.now().getEpochSecond();
		dispatch.setId(id);
		dispatch.setCapacity(capacity);
		dispatch.setFuelType(fuelType);
		dispatch.setDispatchedDate(LocalDateTime.now());
		
		dispatchRepository.save(dispatch);
		
		return dispatch;
		
	}

}
