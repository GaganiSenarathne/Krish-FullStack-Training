package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.InventoryAvailable;

@Repository
public interface InventoryAvailableRepository extends MongoRepository<InventoryAvailable, Integer>{
	
//	Database method - Find records by Fuel Type 
	InventoryAvailable findByFuelType(String type);

}
