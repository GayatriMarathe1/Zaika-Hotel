package com.zaika.service;

import java.util.List;

import com.zaika.Exception.RestaurantException;
import com.zaika.model.Category;

public interface CategoryService {
	
	public Category createCategory (String name,Long userId) throws RestaurantException;
	public List<Category> findCategoryByRestaurantId(Long restaurantId) throws RestaurantException;
	public Category findCategoryById(Long id) throws RestaurantException;

}
