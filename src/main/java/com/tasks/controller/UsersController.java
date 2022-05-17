package com.tasks.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tasks.models.Users;

public interface UsersController extends JpaRepository<Users, Integer> {
	
	Optional<Users> findByUsernameAndPassword(String username, String password);
	//Optional<Users> findByUsername(String username);
}
