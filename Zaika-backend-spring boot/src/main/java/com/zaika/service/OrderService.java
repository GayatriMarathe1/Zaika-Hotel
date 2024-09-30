package com.zaika.service;

import java.util.List;

import com.stripe.exception.StripeException;
import com.zaika.Exception.CartException;
import com.zaika.Exception.OrderException;
import com.zaika.Exception.RestaurantException;
import com.zaika.Exception.UserException;
import com.zaika.model.Order;
import com.zaika.model.PaymentResponse;
import com.zaika.model.User;
import com.zaika.request.CreateOrderRequest;

public interface OrderService {
	
	 public PaymentResponse createOrder(CreateOrderRequest order, User user) throws UserException, RestaurantException, CartException, StripeException;
	 
	 public Order updateOrder(Long orderId, String orderStatus) throws OrderException;
	 
	 public void cancelOrder(Long orderId) throws OrderException;
	 
	 public List<Order> getUserOrders(Long userId) throws OrderException;
	 
	 public List<Order> getOrdersOfRestaurant(Long restaurantId,String orderStatus) throws OrderException, RestaurantException;
	 

}
