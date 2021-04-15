package com.nitinraj.hotelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitinraj.hotelbooking.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

}
