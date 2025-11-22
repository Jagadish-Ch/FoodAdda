//package com.foodAdda;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import jakarta.persistence.PersistenceContext;
//import jakarta.transaction.Transactional;
//
//@Service
//public class MenuServiceImpl {
//	@Autowired	
//	private MenuRepository menuRepository;
//
//	public void addItem(Menu menu) {
//		menuRepository.addItem(menu);
//	}
//
//	public Menu getItem(Integer id) {
//		return menuRepository.getItemById(id);
//	}
//
//	public Menu updateItem(Menu menu) {
//		return menuRepository.updateItem(menu);
//	}
//
//	public void deleteItem(Integer id) {
//		menuRepository.deleteItem(id);
//	}
//
//	public List<Menu> getAllItems() {
//		return menuRepository.getAllItems();
//	}
//
//	public List<Menu> getItemsByCategory(String category) {
//		return menuRepository.getItemsByCategory(category);
//	}
//
//	public List<Menu> getItemsOrderedByPrice() {
//		return menuRepository.getItemsOrderedByPrice();
//	}
//
//	public List<Object[]> getAveragePriceByCategory() {
//		return menuRepository.getAveragePriceByCategory();
//	}
//}
