package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import fuelApp.model.Order;


public interface OrderService {
	
//	Methods for the order placement
	public ResponseEntity<Order> saveOrder(Order order);
	public ResponseEntity<Order> getRecivedOrderById(int id, String status);
	public ResponseEntity<List<Order>> getOrderByShedID(int shedId);
	public ResponseEntity<List<Order>> getAllOrders();	
	
}
