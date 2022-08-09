package com.example.demo.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.Dispatch;

public interface DispatchService {
	
	public ResponseEntity<Dispatch> saveSchedule(Dispatch dispatch);

}
