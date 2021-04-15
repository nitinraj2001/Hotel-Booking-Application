package com.nitinraj.hotelbooking.Service;

import org.springframework.stereotype.Service;

import com.nitinraj.hotelbooking.model.BookingDetail;

@Service
public interface BookingDetailService {
	
	public void savebookingdetail(BookingDetail theBookingDetail);

}
