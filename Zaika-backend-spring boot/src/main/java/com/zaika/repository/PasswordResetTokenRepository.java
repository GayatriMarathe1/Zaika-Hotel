package com.zaika.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaika.model.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
	PasswordResetToken findByToken(String token);
}
