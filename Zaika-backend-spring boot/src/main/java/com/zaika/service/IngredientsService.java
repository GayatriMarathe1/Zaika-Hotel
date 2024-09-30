package com.zaika.service;

import java.util.List;

import com.zaika.Exception.FoodException;
import com.zaika.Exception.RestaurantException;
import com.zaika.model.Food;
import com.zaika.model.IngredientCategory;
import com.zaika.model.IngredientsItem;
import com.zaika.repository.IngredientsCategoryRepository;

public interface IngredientsService {
	
	public IngredientCategory createIngredientsCategory(
			String name,Long restaurantId) throws RestaurantException;

	public IngredientCategory findIngredientsCategoryById(Long id) throws Exception;

	public List<IngredientCategory> findIngredientsCategoryByRestaurantId(Long id) throws Exception;
	
	public List<IngredientsItem> findRestaurantsIngredients(
			Long restaurantId);

	
	public IngredientsItem createIngredientsItem(Long restaurantId, 
			String ingredientName,Long ingredientCategoryId) throws Exception;

	public IngredientsItem updateStoke(Long id) throws Exception;
	
}
