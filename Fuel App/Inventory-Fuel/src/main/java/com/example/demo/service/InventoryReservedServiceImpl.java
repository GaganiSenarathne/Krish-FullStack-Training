package com.example.demo.service;

import java.time.Instant;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.kafkaConfig.KafkaTopic;
import com.example.demo.repository.InventoryReservedRepository;

import fuelApp.model.InventoryReserved;

@Service
public class InventoryReservedServiceImpl implements InventoryReservedService{

	
	@Autowired
	InventoryReservedRepository inventoryReservedRepository;
	
	@Autowired
	KafkaTemplate<String, InventoryReserved> kafkaTemplate;
	
	@Override
	public InventoryReserved saveReservedInventory(InventoryReserved inventoryReserved) {

		return inventoryReservedRepository.save(inventoryReserved);
	}

	@Override
	public InventoryReserved getFromInventoryAvailable(String orderRefId, String fuelType, int fuelCapacity, int shedID) {
		InventoryReserved inventoryReserved = new InventoryReserved();
		
		String status = "Allocated";
		
		long id = Instant.now().getEpochSecond();
		inventoryReserved.setId(id);
		inventoryReserved.setRefID(orderRefId);
		inventoryReserved.setFuelType(fuelType);
		inventoryReserved.setShedID(shedID);
		inventoryReserved.setQty(fuelCapacity);
		inventoryReserved.setStatus(status);
		inventoryReserved.setDateTime(LocalDateTime.now());
		
		kafkaTemplate.send(KafkaTopic.MESSAGE_TOPIC, inventoryReserved);
		
		return saveReservedInventory(inventoryReserved);
	}


}
