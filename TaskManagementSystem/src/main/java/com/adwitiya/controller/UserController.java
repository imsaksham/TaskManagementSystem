package com.adwitiya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adwitiya.service.UserService;
import com.adwitiya.service.UserServiceImplementation;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/hello")
	ResponseEntity<String> hello() {
		return ResponseEntity.ok("Hello");
	}
}
