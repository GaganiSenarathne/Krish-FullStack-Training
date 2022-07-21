package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentcloud.commons.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
