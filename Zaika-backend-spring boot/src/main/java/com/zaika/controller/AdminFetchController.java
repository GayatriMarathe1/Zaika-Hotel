package com.zaika.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaika.model.Restaurant;
import com.zaika.repository.RestaurantRepository;

@RestController
@RequestMapping("/api/admin")
public class AdminFetchController {

	@Autowired
	private RestaurantRepository resRepository;
	
	@GetMapping("/all-restaurants")
	public ResponseEntity<List<Restaurant>> getAllRestaurnats(){
		return ResponseEntity.ok(resRepository.findAll());
	}
	
}
