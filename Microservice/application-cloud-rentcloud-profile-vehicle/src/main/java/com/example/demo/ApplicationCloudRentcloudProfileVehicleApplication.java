package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.rentcloud.commons.model")
public class ApplicationCloudRentcloudProfileVehicleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationCloudRentcloudProfileVehicleApplication.class, args);
	}

}
