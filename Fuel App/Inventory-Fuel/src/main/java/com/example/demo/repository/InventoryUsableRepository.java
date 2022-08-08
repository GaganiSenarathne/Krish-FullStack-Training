package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.InventoryUsable;

public interface InventoryUsableRepository extends MongoRepository<InventoryUsable, Integer>{
	
//	Database method - Find records by Fuel Type 
	InventoryUsable findByFuelType(String type);
//	InventoryUsable updateByFuelType(String type);
//	InventoryUsable customMaxID();

}