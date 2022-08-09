package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import fuelApp.model.InventoryReserved;

@Repository
public interface InventoryReservedRepository extends MongoRepository<InventoryReserved, Integer>{

	InventoryReserved findTopByOrderByIdDesc();

}
