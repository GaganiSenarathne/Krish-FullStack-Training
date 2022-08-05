package com.example.demo.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.InventoryAvailable;

public interface InventoryAvailableService {
	
	public ResponseEntity<InventoryAvailable> saveFuelAvailable(InventoryAvailable inventoryAvailable);
//	public InventoryAvailable getCapacity(String fuelType, int Capacity, String RefID);

}
