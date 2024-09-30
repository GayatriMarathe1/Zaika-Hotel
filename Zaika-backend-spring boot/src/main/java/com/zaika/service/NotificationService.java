package com.zaika.service;

import java.util.List;

import com.zaika.model.Notification;
import com.zaika.model.Order;
import com.zaika.model.Restaurant;
import com.zaika.model.User;

public interface NotificationService {
	
	public Notification sendOrderStatusNotification(Order order);
	public void sendRestaurantNotification(Restaurant restaurant, String message);
	public void sendPromotionalNotification(User user, String message);
	
	public List<Notification> findUsersNotification(Long userId);

}
