package com.foodAdda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodAdda.entity.Address;
import com.foodAdda.entity.Restaurant;
import com.foodAdda.entity.User;
import com.foodAdda.exception.DuplicateRestaurantException;
import com.foodAdda.exception.ResourceNotFoundException;
import com.foodAdda.repository.AddressRepository;
import com.foodAdda.repository.RestaurantRepository;
import com.foodAdda.repository.UserRepository;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public Restaurant registerRestaurant(Restaurant restaurant) {
		User vendor = userRepository.findById(restaurant.getVendor().getId())
				.orElseThrow(()->new ResourceNotFoundException("Vendor not found"));
		restaurant.setVendor(vendor);
		if(! restaurant.getVendor().getUserRole().equalsIgnoreCase("vendor")){
			throw new RuntimeException("Vendors can only able to Register a Restaurant");
		}
		Optional<Restaurant> data = restaurantRepository.findByNameAndContactNo(restaurant.getName(), restaurant.getContactNo());
		
		if(data.isPresent()) {
			throw new DuplicateRestaurantException("Sorry! Restaurant already exists for the");
		}
		
		Address savedAddress = addressRepository.save(restaurant.getAddress());
		restaurant.setAddress(savedAddress);
		
		
//		restaurant.setStatus("PENDING");
//		restaurant.setRating(2.5);
		
		
		return restaurantRepository.save(restaurant);
		
//				.orElseThrow(()-> new RuntimeException(""))
	}


	public List<Restaurant> getAllRestaurants() {
		return restaurantRepository.findAll();
	}
}
