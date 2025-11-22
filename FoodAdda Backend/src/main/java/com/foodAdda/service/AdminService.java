package com.foodAdda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodAdda.entity.Restaurant;
import com.foodAdda.exception.IllegalStatusException;
import com.foodAdda.exception.ResourceNotFoundException;
import com.foodAdda.repository.RestaurantRepository;

@Service
public class AdminService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public List<Restaurant>getPendingRestaurants(){
		System.out.println("AdminService @Method getPendingRestaurants is executing..."); // while method executing
//		throw new RuntimeException("Throwing Exception");
		return restaurantRepository.findByStatus("PENDING");
	}
	
	public void approveRestaurant(Long restaurantId) {
		//Checking is Restaurant Found or not with the given ID
		Restaurant restaurant = restaurantRepository.findById(restaurantId)
				.orElseThrow(()->new ResourceNotFoundException("Restaurant not found"));
		
		//if Found, check it's status is Pending or not
		//if not(i.e., restaurant status->SUCCESS) throw Exception
		if(!"PENDING".equalsIgnoreCase(restaurant.getStatus())) {
			throw new IllegalStatusException("only pending Restaurants can be approved");
		}
		
		//Approve
		restaurant.setStatus("APPROVED");
		restaurantRepository.save(restaurant);
	}
	
	public void rejectRestaurant(Long restaurantId) {
		//Checking is Restaurant Found or not with the given ID
		Restaurant restaurant = restaurantRepository.findById(restaurantId)
				.orElseThrow(()->new ResourceNotFoundException("Restaurant not found"));

		//if Found, check it's status is Pending or not
		//if not(i.e., restaurant status->SUCCESS) throw Exception
		if(!"PENDING".equalsIgnoreCase(restaurant.getStatus())) {
			throw new IllegalStatusException("only pending Restaurants can be rejected");
		}

		//Approve
		restaurant.setStatus("REJECTED");
		restaurantRepository.save(restaurant);
	}
	
	public List<Restaurant>getLowRatedRestaurants(){
		return restaurantRepository.findByRatingLessThan(1.5);
	}
	
	public void removeRestaurant(Long restaurantId) {
		//Checking is Restaurant Found or not with the given ID
		Restaurant restaurant = restaurantRepository.findById(restaurantId)
				.orElseThrow(()->new ResourceNotFoundException("Restaurant not found"));
		//delete
		restaurantRepository.delete(restaurant);
	}
}
