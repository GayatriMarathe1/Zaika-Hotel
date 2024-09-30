package com.zaika.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaika.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
