package com.foodAdda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodAdda.entity.User;
import com.foodAdda.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {
		return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
	}
	
	//Login existing user
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestParam String contactNumber,@RequestParam String password) {
		return new ResponseEntity<>(userService.loginUser(contactNumber, password), HttpStatus.CREATED);
	}
	
	//Logout user
	@GetMapping("/logout")
	public ResponseEntity<String> logoutUser() {
		return new ResponseEntity<>(userService.logoutUser(), HttpStatus.OK);
	}
	
	
	//=======================For debugging=============================
	// Get All Users
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
}
