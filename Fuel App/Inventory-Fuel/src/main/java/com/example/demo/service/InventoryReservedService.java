package com.example.demo.service;

import fuelApp.model.InventoryReserved;

public interface InventoryReservedService {

	public InventoryReserved saveReservedInventory(InventoryReserved inventoryReserved);
	public InventoryReserved getFromInventoryAvailable(String orderRefId, String fuelType, int fuelCapacity, int shedID);
}
