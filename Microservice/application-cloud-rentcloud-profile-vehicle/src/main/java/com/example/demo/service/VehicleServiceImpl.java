package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.VehicleRepository;
import com.rentcloud.commons.model.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepository vehicleRepository;
	
	@Override
	public Vehicle save(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

}
