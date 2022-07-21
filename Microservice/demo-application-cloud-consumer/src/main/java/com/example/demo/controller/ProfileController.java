package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MemberProfileConfiguration;

@RestController
public class ProfileController {

	@Autowired
	MemberProfileConfiguration profileConfiguration;
	
	@RequestMapping("/profile")
	public MemberProfileConfiguration getConfif() {
		return profileConfiguration;
	}
}
