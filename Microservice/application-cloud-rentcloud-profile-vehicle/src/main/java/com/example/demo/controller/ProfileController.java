package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.VehicleService;
import com.rentcloud.commons.model.Vehicle;

@RestController
@RequestMapping(value = "/services")
public class ProfileController {

	@Autowired
	VehicleService vehicleService;
	
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public Vehicle save(@RequestBody Vehicle vehicle) {
		return vehicleService.save(vehicle);		
	}
}
