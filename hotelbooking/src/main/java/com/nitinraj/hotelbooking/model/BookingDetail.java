package com.nitinraj.hotelbooking.model;

import javax.persistence.*;

@Entity
@Table(name="bookingdetail")
public class BookingDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bookingNo")
	private int bookingNo;
	
	@Column(name="bookingId")
	private String bookingId;
	
	@Column(name="bookedRoomNo")
	private int bookedRoomNo;

	@Column(name="noOfDays")
	private int noOfDays;
	
	@Column(name="checkInDate")
	private String checkInDate;
	
	@Column(name="checkOutDate")
	private String checkOutDate;
	
	@Column(name="checkInTime")
	private String checkInTime;

	public BookingDetail() {
		super();
		
	}

	public BookingDetail(String bookingId, int noOfDays, String checkInDate, String checkOutDate, String checkInTime, int bookedRoomNo ) {
		super();
		this.bookingId = bookingId;
		this.noOfDays = noOfDays;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.checkInTime = checkInTime;
		this.bookedRoomNo=bookedRoomNo;
	}

	public int getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}
	
	public int getBookedRoomNo() {
		return bookedRoomNo;
	}

	public void setBookedRoomNo(int bookedRoomNo) {
		this.bookedRoomNo = bookedRoomNo;
	}

	@Override
	public String toString() {
		return "BookingDetail [bookingNo=" + bookingNo + ", bookingId=" + bookingId + ", bookedRoomNo=" + bookedRoomNo
				+ ", noOfDays=" + noOfDays + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate
				+ ", checkInTime=" + checkInTime + "]";
	}

	
	
	
	

	

}
