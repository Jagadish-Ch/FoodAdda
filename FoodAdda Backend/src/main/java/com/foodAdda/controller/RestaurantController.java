package com.foodAdda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodAdda.entity.Restaurant;
import com.foodAdda.entity.User;
import com.foodAdda.exception.DuplicateRestaurantException;
import com.foodAdda.service.RestaurantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerRestaurant(@Valid @RequestBody Restaurant restaurant) throws DuplicateRestaurantException{
		restaurantService.registerRestaurant(restaurant);
		return new ResponseEntity<String>("Congratulations, restaurant registered successfully!",HttpStatus.CREATED);
//		return ResponseEntity.created("Congratulations, restaurant registered successfully!");
	}
	
	//=======================For debugging=============================
		// Get All Restaurants
		@GetMapping
		public List<Restaurant> getAllRestaurants(){
			return restaurantService.getAllRestaurants();
		}
}
