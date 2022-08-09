package com.example.demo.listener;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import fuelApp.model.InventoryReserved;

@Component
public class Listener {
	
	
//	Will listen to the Order Topic and the Group 01
	@KafkaListener(topics = "topic_order_status", groupId = "group-03")
	public void jsonConsume(@Payload List<InventoryReserved> data){

        String value = String.valueOf(data);
        String fuelType = "";
        String refId = "";
        String status = "";
        int shedID = 0;
        int fuelCapacity = 0;
        LocalDateTime dateTime = null;
      
        ObjectMapper objectMapper = new ObjectMapper();
        try {

        	List<InventoryReserved> reservedOrders = objectMapper.readValue(value, new TypeReference<List<InventoryReserved>>(){});
            for(InventoryReserved reservedOrder : reservedOrders) {
                
            	fuelType = reservedOrder.getFuelType();
                fuelCapacity = reservedOrder.getQty();
                refId  = reservedOrder.getRefID();
                shedID = reservedOrder.getShedID();
                dateTime = reservedOrder.getDateTime();
                status = reservedOrder.getStatus();
                
            }
            
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        System.out.println("refId =" + refId + ", fuelType =" + fuelType + ", shedID=" + shedID + ", qty=" + fuelCapacity + ", status=" + status + ", dateTime=" + dateTime );

    }
	

}
