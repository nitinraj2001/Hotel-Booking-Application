package com.nitinraj.hotelbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.nitinraj.hotelbooking.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

	@Query(" select u from Room u where u.bookedStatus=false") 
	public List<Room> findAll();
}
