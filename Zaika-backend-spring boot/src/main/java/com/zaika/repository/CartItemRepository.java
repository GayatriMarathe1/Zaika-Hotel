package com.zaika.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaika.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {


//    CartItem findByFoodIsContaining

}
