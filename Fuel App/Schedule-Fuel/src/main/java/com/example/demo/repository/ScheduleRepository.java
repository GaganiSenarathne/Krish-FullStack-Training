package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Schedule;

@Repository
public interface ScheduleRepository extends MongoRepository<Schedule, Long>{
	
	
}