package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import fuelApp.model.Order;



@Repository
public interface OrderRepository extends MongoRepository<Order, Integer>{
	
//	Database method - search order by Shed ID
	public Order findByRefId(String refID);	

}
