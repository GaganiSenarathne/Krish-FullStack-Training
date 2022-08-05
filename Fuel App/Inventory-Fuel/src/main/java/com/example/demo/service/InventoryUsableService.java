package com.example.demo.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.InventoryUsable;

public interface InventoryUsableService {
	
	public ResponseEntity<InventoryUsable> saveFuelUsable(InventoryUsable inventoryUsable);
	public ResponseEntity<InventoryUsable> updateFuelUsable(InventoryUsable inventoryUsable, int usableCapacity);
	public InventoryUsable getUsableCapacity(String fuelType, int Capacity, String RefID, int shedID);

}
