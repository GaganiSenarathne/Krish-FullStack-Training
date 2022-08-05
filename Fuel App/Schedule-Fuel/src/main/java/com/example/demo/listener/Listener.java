package com.example.demo.listener;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.example.demo.service.ScheduleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import fuelApp.model.Order;

@Component
public class Listener {
	
	@Autowired
	ScheduleService scheduleService;
	
	@KafkaListener(topics = "topic_order", groupId = "group-02")
	public void jsonConsume(@Payload List<Order> data){

        String value = String.valueOf(data);
        String fuelType = "";
        String refId = "";
        int shedID = 0;
        int fuelCapacity = 0;
      
        ObjectMapper objectMapper = new ObjectMapper();
        try {

        	List<Order> orders = objectMapper.readValue(value, new TypeReference<List<Order>>(){});
            for(Order order : orders) {
                
            	fuelType = order.getFuelType();
                fuelCapacity = order.getCapacity();
                refId  = order.getRefId();
                shedID = order.getShedId();
                
            }
            
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println(scheduleService.getOrderDetails(fuelType,fuelCapacity,refId,shedID));

    }

}
