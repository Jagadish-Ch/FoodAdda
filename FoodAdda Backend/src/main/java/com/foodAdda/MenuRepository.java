//package com.foodAdda;
//
//import java.nio.file.AccessDeniedException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.transaction.Transactional;
//
//@Repository
//@Transactional
//public class MenuRepository {
//	@PersistenceContext
//	EntityManager entityManager;
//
//	public void addItem(Menu menu) {
//		entityManager.persist(menu);
//	}
//	public Menu getItemById(int id) {
//		return entityManager.find(Menu.class, id);
//	}
//	public Menu updateItem(Menu menu) {
//		return entityManager.merge(menu);
//	}
//	public void deleteItem(int id) {
//		Menu menu = getItemById(id);
//		if(menu != null) {
//			entityManager.remove(menu);
//		}
//	}
//	public List<Menu> getAllItems(){
//		String jpql = "SELECT m FROM Menu m";
//		return entityManager.createQuery(jpql, Menu.class).getResultList();
//	}
//
//	// JPQL: Filter by category
//	public List<Menu> getItemsByCategory(String category) {
//		String jpql = "SELECT m FROM Menu m WHERE m.category = :category";
//		return entityManager.createQuery(jpql, Menu.class)
//				.setParameter("category", category)
//				.getResultList();
//	}
//
//	// JPQL: Order by price
//	public List<Menu> getItemsOrderedByPrice() {
//		String jpql = "SELECT m FROM Menu m ORDER BY m.price ASC";
//		return entityManager.createQuery(jpql, Menu.class).getResultList();
//	}
//
//	// JPQL: Group by category with average price
//	public List<Object[]> getAveragePriceByCategory() {
//		String jpql = "SELECT m.category, AVG(m.price) FROM Menu m GROUP BY m.category";
//		return entityManager.createQuery(jpql, Object[].class).getResultList();
//	}
//}
