package com.foodAdda.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodAdda.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	Optional<Restaurant> findByNameAndContactNo(String name, String contactNo);
	List<Restaurant> findByStatus(String status);
	List<Restaurant> findByRatingLessThan(double rating);
}
