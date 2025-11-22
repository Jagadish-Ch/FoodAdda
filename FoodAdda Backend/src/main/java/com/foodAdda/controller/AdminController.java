package com.foodAdda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodAdda.entity.Restaurant;
import com.foodAdda.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/restaurants/pending")
	public ResponseEntity<List<Restaurant>> getPendingRestaurants(){
//		System.out.println("AdminService @Method getPendingRestaurants is start it's exexution");//before executing method
		List<Restaurant> lr = adminService.getPendingRestaurants();
//		System.out.println("AdminService @Method getPendingRestaurants is end it's exexution");//after execution
		return new ResponseEntity<List<Restaurant>>(lr, HttpStatus.OK);
	}
	
	@PutMapping("/restaurants/{restaurantId}/approve")
	public ResponseEntity<String> approveRestaurant(@PathVariable Long restaurantId){
		adminService.approveRestaurant(restaurantId);
		return new ResponseEntity<String>("Restaurant registration request approved!", HttpStatus.OK);
	}
	
	@PutMapping("/restaurants/{restaurantId}/reject")
	public ResponseEntity<String> rejectRestaurant(@PathVariable Long restaurantId){
		adminService.rejectRestaurant(restaurantId);
		return new ResponseEntity<String>("Restaurant registration request rejected!", HttpStatus.OK);
	}
	
	@GetMapping("/restaurants/low-rating")
	public ResponseEntity<List<Restaurant>> getLowRatedRestaurants(){
		return new ResponseEntity<List<Restaurant>>(adminService.getLowRatedRestaurants(), HttpStatus.OK);
	}
	
	@DeleteMapping("/restaurants/{restaurantId}/remove")
	public ResponseEntity<String> removeRestaurant(@PathVariable Long restaurantId){
		adminService.removeRestaurant(restaurantId);
		return new ResponseEntity<String>("Restaurant Removed Successfully", HttpStatus.OK);
	}
}
