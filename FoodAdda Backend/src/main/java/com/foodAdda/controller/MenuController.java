package com.foodAdda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodAdda.entity.Menu;
import com.foodAdda.service.MenuService;



@RestController
@RequestMapping("/api/vendor/menu")
public class MenuController {
 
	@Autowired
    private MenuService menuService;
 
    // ADD DISH
    @PostMapping("/add/{restaurantId}")
    public ResponseEntity<String> addDish(@PathVariable Long restaurantId, @RequestBody Menu menu) {
        menuService.addDish(restaurantId, menu);
        return ResponseEntity.ok("Dish added successfully!");
    }
 
    // UPDATE DISH
    @PutMapping("/update/{menuId}")
    public ResponseEntity<String> updateDish(@PathVariable Long menuId, @RequestBody Menu menu) {
        menuService.updateDish(menuId, menu);
        return ResponseEntity.ok("Dish updated successfully!");
    }
 
    // DELETE DISH
    @DeleteMapping("/delete/{menuId}")
    public ResponseEntity<String> deleteDish(@PathVariable Long menuId) {
        menuService.deleteDish(menuId);
        return ResponseEntity.ok("Dish deleted successfully!");
    }
 
    // LIST DISHES
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<?> getMenu(@PathVariable Long restaurantId) {
        return ResponseEntity.ok(menuService.getMenuByRestaurant(restaurantId));
    }
}
//@RestController
//@RequestMapping("/api/menu")
//public class MenuController {
//	
//	@Autowired
//	private MenuService menuService;
//	
//	@PostMapping("/{restaurantId}/add-dish")
//	public ResponseEntity<String> addDish(@PathVariable Long restaurantId,@RequestBody Menu menu){
//		menuService.addDish(restaurantId, menu);
//		return new ResponseEntity<String>("Dish Added Succefully", HttpStatus.OK);
//	}
//	
//	@PutMapping("/update-dish/{menuId}")
//	public ResponseEntity<String> updateDish(@PathVariable Long menuId,@RequestBody Menu menu){
//		menuService.updateDish(menuId, menu);
//		return new ResponseEntity<String>("Dish Updated Succefully", HttpStatus.OK);
//	}
//	
//	@DeleteMapping("/delete-dish/{menuId}")
//	public ResponseEntity<String> deleteDish(@PathVariable Long menuId){
//		menuService.deleteDish(menuId);
//		return new ResponseEntity<String>("Dish Deleted Succefully", HttpStatus.OK);
//	}
//	
//	@GetMapping("/{restaurantId}/dishes")
//	public ResponseEntity<List<Menu>> getMenuByRestaurant(Long restaurantId) {
//        return new ResponseEntity<List<Menu>>(menuService.getMenuByRestaurant(restaurantId), HttpStatus.OK);
//    }
//}
