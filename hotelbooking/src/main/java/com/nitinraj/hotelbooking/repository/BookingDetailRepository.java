package com.nitinraj.hotelbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nitinraj.hotelbooking.model.BookingDetail;

@Repository
public interface BookingDetailRepository extends JpaRepository<BookingDetail, Integer> {

}
