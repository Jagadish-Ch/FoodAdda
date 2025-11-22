package com.foodAdda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodAdda.entity.Menu;
import com.foodAdda.entity.Restaurant;
import com.foodAdda.exception.IllegalStatusException;
import com.foodAdda.exception.ResourceNotFoundException;
import com.foodAdda.repository.MenuRepository;
import com.foodAdda.repository.RestaurantRepository;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	
	//--------------------------------Add Dish------------------------------
	public Menu addDish(Long restaurantId, Menu menu) {
		Restaurant restaurant = restaurantRepository.findById(restaurantId)
				.orElseThrow(()->new ResourceNotFoundException("Restaurant not found"));
		
		//Restaurant must be approved
		if(!"APPROVED".equalsIgnoreCase(restaurant.getStatus())) {
			throw new IllegalStateException("Restaurant is not approved by admin");
		}
		//Validate dish name starts with upper case
		if(!menu.getName().matches("^[A-Z][a-zA-Z ]+$")) {
			throw new IllegalStateException("Dish name must starts with uppercase and contain only alphabets");
		}
		//Validate dish type
		if(! List.of("Vegetarian","Non-vegetarian","Eggetarian","Jain").contains(menu.getType())) {
			throw new IllegalStateException("Invalid dish type");
		}
		if(menu.getPrice() <= 0) {
			throw new IllegalStateException("Price must be greater than 0");
		}
		//Dish Already exists?
		menuRepository.findByNameAndRestaurantId(menu.getName(), restaurantId)
		.ifPresent(d->{throw new IllegalStatusException("Dish already exists for this restaurant"); });
		
		menu.setRestaurant(restaurant);
		menu.setRating(2.5); //default rating
		
		return menuRepository.save(menu);
	}
	
	// -------------------- UPDATE DISH --------------------
    public Menu updateDish(Long menuId, Menu updated) {
 
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new ResourceNotFoundException("Dish not found"));
 
        if (!updated.getName().matches("^[A-Z][a-zA-Z ]+$")) {
            throw new IllegalArgumentException("Dish name must start with uppercase and contain only alphabets/spaces");
        }
 
        if (!List.of("Vegetarian","Non-vegetarian","Eggetarian","Jain").contains(updated.getType())) {
            throw new IllegalArgumentException("Invalid dish type");
        }
 
        if (updated.getPrice() <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
 
        // update all fields except rating
        menu.setName(updated.getName());
        menu.setType(updated.getType());
        menu.setDescription(updated.getDescription());
        menu.setSpecialty(updated.getSpecialty());
        menu.setPrice(updated.getPrice());
 
        return menuRepository.save(menu);
    }
 
    // -------------------- DELETE DISH --------------------
    public void deleteDish(Long menuId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new ResourceNotFoundException("Dish not found"));
        menuRepository.delete(menu);
    }
 
    // -------------------- GET MENU LIST --------------------
    public List<Menu> getMenuByRestaurant(Long restaurantId) {
        return menuRepository.findByRestaurantId(restaurantId);
    }
}

