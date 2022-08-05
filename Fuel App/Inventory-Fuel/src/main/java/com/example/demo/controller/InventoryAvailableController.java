package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.InventoryUsable;
import com.example.demo.service.InventoryUsableService;

@RestController
public class InventoryAvailableController {

	@Autowired
	InventoryUsableService inventoryUsableService;
	
	
	@PostMapping("/available")
	public ResponseEntity<InventoryUsable> saveAvailableFuel(@RequestBody InventoryUsable inventoryUsable) {
		return inventoryUsableService.saveFuelUsable(inventoryUsable);
	}
}
