package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.OrderService;

import fuelApp.model.Order;

@RestController
@RequestMapping("api/v1/order") // Request Mapping with the version
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class OrderController {
	
	@Autowired
	OrderService orderService;


	@PostMapping
	public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
		return orderService.saveOrder(order);
	}
	
	@GetMapping("/{shedId}")
	public ResponseEntity<List<Order>> getOrderById(@PathVariable int shedId){
		return orderService.getOrderByShedID(shedId);
	}
	
	@PutMapping("/{id}/{status}")
	public ResponseEntity<Order> getOrderReceived(@PathVariable int id, @PathVariable String status) {
		return orderService.getRecivedOrderById(id,status);
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	

}