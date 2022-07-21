package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CustomerRepository;
import com.rentcloud.commons.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

}
