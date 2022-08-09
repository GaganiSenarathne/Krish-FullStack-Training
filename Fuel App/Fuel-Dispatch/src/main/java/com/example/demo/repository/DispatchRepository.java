package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Dispatch;

@Repository
public interface DispatchRepository extends MongoRepository<Dispatch, Long>{
	

}
