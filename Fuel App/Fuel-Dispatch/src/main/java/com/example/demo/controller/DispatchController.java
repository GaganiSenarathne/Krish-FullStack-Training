package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Dispatch;
import com.example.demo.service.DispatchService;

@RestController
@RequestMapping("Dispatch") // Request Mapping with the version
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class DispatchController {
	
	@Autowired
	DispatchService dispatchService;
	
	@PostMapping
	public ResponseEntity<Dispatch> saveDispatchOrder(@RequestBody Dispatch dispatch) {
		return dispatchService.saveSchedule(dispatch);
	}

}
