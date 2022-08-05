package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import fuelApp.model.Order;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer>{
	
//	Database method - search order by Shed ID
	public List<Order> findByShedId(int id);	

}
