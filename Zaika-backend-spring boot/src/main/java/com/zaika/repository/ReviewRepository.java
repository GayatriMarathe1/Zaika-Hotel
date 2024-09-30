package com.zaika.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaika.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
