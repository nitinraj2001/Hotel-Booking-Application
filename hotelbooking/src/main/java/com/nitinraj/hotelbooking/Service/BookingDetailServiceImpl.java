package com.nitinraj.hotelbooking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nitinraj.hotelbooking.model.BookingDetail;
import com.nitinraj.hotelbooking.repository.BookingDetailRepository;

@Service
@Transactional
public class BookingDetailServiceImpl implements BookingDetailService {
	
	@Autowired
	private BookingDetailRepository theBookingDetailRepo;
	

	@Override
	public void savebookingdetail(BookingDetail theBookingDetail) {
		
		theBookingDetailRepo.save(theBookingDetail);
		
	}

}
