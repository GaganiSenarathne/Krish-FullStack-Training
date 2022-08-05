package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.InventoryAvailable;
import com.example.demo.repository.InventoryAvailableRepository;

@Service
public class InventoryAvailableServiceImpl implements InventoryAvailableService{

	@Autowired
	InventoryAvailableRepository availableRepository;
	
	@Autowired
	InventoryReservedService inventoryReservedService;
	
	
//	@Autowired
//	RestTemplate restTemplate;
	
	@Override
	public ResponseEntity<InventoryAvailable> saveFuelAvailable(InventoryAvailable inventoryAvailable) {
		try {
//			Saving Available Fuel QTY
			availableRepository.save(inventoryAvailable);
		
		}catch(Exception e) {
			
		}
	
		return ResponseEntity.status(HttpStatus.OK).body(inventoryAvailable);	
	}

//	@Override
//	public InventoryAvailable getCapacity(String fuelType, int Capacity, String RefID) {
//		
//		InventoryAvailable inventoryAvailable = availableRepository.findByFuelType(fuelType);
//		InventoryUsable usable = new InventoryUsable();
//		int availableCapacity = inventoryAvailable.getQty();
////		String status = "Allocated";
////		// if(capacity>=fuelCapacity){
////			 
////			// Order newOrder = getOrder(orderRefeId, "Allocated");
////			 int usableCapacity  = availableCapacity - Capacity;
////			 usable.setQty(usableCapacity);
////			 saveFuelAvailable(inventoryAvailable);
////			 inventoryReservedService.getFromInventoryAvailable(RefID, fuelType, Capacity);
////				//getOrder(orderRefeId, status);
////		// }
//				
//		return inventoryAvailable;
//	}

}
