package com.zaika.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaika.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
