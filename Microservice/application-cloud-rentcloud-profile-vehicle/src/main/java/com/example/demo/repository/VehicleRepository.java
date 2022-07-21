package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentcloud.commons.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{

}
