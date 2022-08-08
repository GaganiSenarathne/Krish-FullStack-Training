package com.example.demo.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.kafkaConfig.KafkaTopic;
import com.example.demo.repository.OrderRepository;

import fuelApp.model.Order;

@Service
public class OrderServiceImpl implements OrderService{
	
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	KafkaTemplate<String, Order> kafkaTemplate;

	@Override
	public ResponseEntity<Order> saveOrder(Order order) {
		
//		Generating unique ID for the reference ID
		String refId  = UUID.randomUUID().toString();
		
		long id = Instant.now().getEpochSecond();
		
		try {
			
//			Setting the Reference ID, sending it to the KAFKA and saving it in the Database			
			order.setRefId(refId);
			order.setId(id);
			order.setDateTime(LocalDateTime.now());
			orderRepository.save(order);
			kafkaTemplate.send(KafkaTopic.MESSAGE_TOPIC, order);
			
		}catch(Exception e) {
			
			System.err.println(e);
			
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(order);
	}

	@Override
	public ResponseEntity<Order> getRecivedOrderById(int id, String status) {
		
		Optional<Order> byId = orderRepository.findById(id);
		
//		If the order is exist 
		if(byId.isPresent()) {
			Order order = byId.get();
			
//			Saving the order by setting the status
			order.setStatus(status);
			
			orderRepository.save(order);
			
			return ResponseEntity.status(HttpStatus.OK).body(order);
			
		}else { // If the order is not exist
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<List<Order>> getOrderByShedID(int shedId) {
		
//		Searching order by the shed ID 
		return ResponseEntity.status(HttpStatus.OK).body(orderRepository.findByShedId(shedId));
	}

	@Override
	public ResponseEntity<List<Order>> getAllOrders() {
		
//		Getting all the orders
		return ResponseEntity.status(HttpStatus.OK).body(orderRepository.findAll());
	}

}