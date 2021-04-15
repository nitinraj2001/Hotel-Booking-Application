package com.nitinraj.hotelbooking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roomfacility")
public class RoomFacility {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roomId")
	private int roomId;
	
	@Column(name="additionalBeds")
	private boolean additionalBeds;
	
	@Column(name="babySitting")
	private boolean babySitting;
	
	@Column(name="freeWifi")
	private boolean freeWifi;
	
	@Column(name="laundaryService")
	private boolean laundaryService;
	
	@Column(name="roomService")
	private boolean roomService;
	
	@Column(name="transportation")
	private boolean transportation;
	
	public RoomFacility() {
		super();
		
	}

	public RoomFacility(boolean additionalBeds, boolean babySitting, boolean freeWifi, boolean laundaryService,
			boolean roomService, boolean transportation) {
		super();
		this.additionalBeds = additionalBeds;
		this.babySitting = babySitting;
		this.freeWifi = freeWifi;
		this.laundaryService = laundaryService;
		this.roomService = roomService;
		this.transportation = transportation;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public boolean isAdditionalBeds() {
		return additionalBeds;
	}

	public void setAdditionalBeds(boolean additionalBeds) {
		this.additionalBeds = additionalBeds;
	}

	public boolean isBabySitting() {
		return babySitting;
	}

	public void setBabySitting(boolean babySitting) {
		this.babySitting = babySitting;
	}

	public boolean isFreeWifi() {
		return freeWifi;
	}

	public void setFreeWifi(boolean freeWifi) {
		this.freeWifi = freeWifi;
	}

	public boolean isLaundaryService() {
		return laundaryService;
	}

	public void setLaundaryService(boolean laundaryService) {
		this.laundaryService = laundaryService;
	}

	public boolean isRoomService() {
		return roomService;
	}

	public void setRoomService(boolean roomService) {
		this.roomService = roomService;
	}

	public boolean isTransportation() {
		return transportation;
	}

	public void setTransportation(boolean transportation) {
		this.transportation = transportation;
	}

	@Override
	public String toString() {
		return "RoomFacility [roomId=" + roomId + ", additionalBeds=" + additionalBeds + ", babySitting=" + babySitting
				+ ", freeWifi=" + freeWifi + ", laundaryService=" + laundaryService + ", roomService=" + roomService
				+ ", transportation=" + transportation + "]";
	}

	

	
}
