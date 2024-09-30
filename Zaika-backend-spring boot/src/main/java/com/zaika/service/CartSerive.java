package com.zaika.service;

import com.zaika.Exception.CartException;
import com.zaika.Exception.CartItemException;
import com.zaika.Exception.FoodException;
import com.zaika.Exception.UserException;
import com.zaika.model.Cart;
import com.zaika.model.CartItem;
import com.zaika.model.Food;
import com.zaika.model.User;
import com.zaika.request.AddCartItemRequest;
import com.zaika.request.UpdateCartItemRequest;

public interface CartSerive {

	public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws UserException, FoodException, CartException, CartItemException;

	public CartItem updateCartItemQuantity(Long cartItemId,int quantity) throws CartItemException;

	public Cart removeItemFromCart(Long cartItemId, String jwt) throws UserException, CartException, CartItemException;

	public Long calculateCartTotals(Cart cart) throws UserException;
	
	public Cart findCartById(Long id) throws CartException;
	
	public Cart findCartByUserId(Long userId) throws CartException, UserException;
	
	public Cart clearCart(Long userId) throws CartException, UserException;
	

	

}
