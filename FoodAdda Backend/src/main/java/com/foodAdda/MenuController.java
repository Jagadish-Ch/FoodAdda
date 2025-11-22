//package com.foodAdda;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/menu")
//public class MenuController {
//	@Autowired
//	MenuServiceImpl menuService;
//
//	@PostMapping("/add")
//	public String addItem(@RequestBody Menu menu) {
//		menuService.addItem(menu);
//		return "Item added successfully!";
//	}
//
//	@GetMapping("/{id}")
//	public Menu getItem(@PathVariable Integer id) {
//		return menuService.getItem(id);
//	}
//
//	@PutMapping("/update")
//	public Menu updateItem(@RequestBody Menu menu) {
//		return menuService.updateItem(menu);
//	}
//
//	@DeleteMapping("/delete/{id}")
//	public String deleteItem(@PathVariable Integer id) {
//		menuService.deleteItem(id);
//		return "Item deleted successfully!";
//	}
//
//	@GetMapping("/all")
//	public List<Menu> getAllItems() {
//		return menuService.getAllItems();
//	}
//
//	@GetMapping("/category/{category}")
//	public List<Menu> getByCategory(@PathVariable String category) {
//		return menuService.getItemsByCategory(category);
//	}
//
//	@GetMapping("/orderByPrice")
//	public List<Menu> getItemsOrderedByPrice() {
//		return menuService.getItemsOrderedByPrice();
//	}
//
//	@GetMapping("/avgPriceByCategory")
//	public List<Object[]> getAveragePriceByCategory() {
//		return menuService.getAveragePriceByCategory();
//	}
//}
