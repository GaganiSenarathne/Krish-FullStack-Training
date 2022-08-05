package com.example.demo.service;

import java.time.Instant;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.InventoryReserved;
import com.example.demo.repository.InventoryReservedRepository;

@Service
public class InventoryReservedServiceImpl implements InventoryReservedService{

	
	@Autowired
	InventoryReservedRepository inventoryReservedRepository;
	
	@Override
	public InventoryReserved saveReservedInventory(InventoryReserved inventoryReserved) {

		return inventoryReservedRepository.save(inventoryReserved);
	}

	@Override
	public InventoryReserved getFromInventoryAvailable(String orderRefId, String fuelType, int fuelCapacity, int shedID) {
		InventoryReserved inventoryReserved = new InventoryReserved();
		
		long id = Instant.now().getEpochSecond();
		inventoryReserved.setId(id);
		inventoryReserved.setRefID(orderRefId);
		inventoryReserved.setFuelType(fuelType);
		inventoryReserved.setShedID(shedID);
		inventoryReserved.setQty(fuelCapacity);
		inventoryReserved.setDateTime(LocalDateTime.now());
		return saveReservedInventory(inventoryReserved);
	}


}
