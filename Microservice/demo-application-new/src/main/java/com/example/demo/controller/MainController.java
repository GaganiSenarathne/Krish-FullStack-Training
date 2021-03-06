package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@RestController
public class MainController {
	
	@Autowired
	StudentRepository studentService;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String greetings() {
		return "Hello Boot";
		
	}

	@RequestMapping(value = "/hello", method =  RequestMethod.POST)
	public String greetings2() {
		return "Hello Boot from post";
		
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public Student save(@RequestBody Student student) {
		
		return studentService.save(student);
		
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ResponseEntity<Optional<Student>> fetchStudent(@RequestParam int id) {
		
		Optional<Student> student = studentService.findById(id);
		
		if(student == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok().body(student);
		}
		
	}

}
