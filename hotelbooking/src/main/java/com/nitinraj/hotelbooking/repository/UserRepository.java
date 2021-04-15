package com.nitinraj.hotelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitinraj.hotelbooking.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	Users findByUsername(String username);
	
	

}
