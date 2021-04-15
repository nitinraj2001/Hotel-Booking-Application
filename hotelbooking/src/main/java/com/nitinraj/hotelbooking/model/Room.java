package com.nitinraj.hotelbooking.model;

import java.util.Arrays;

import javax.persistence.*;

@Entity
@Table(name="room")
public class Room {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roomId")
	private int roomId;
	
	@Column(name="roomType")
	private String roomType;
	
	@Column(name="bedType")
	private String bedType;
	
	@Column(name="roomPrice")
	private String roomPrice;
	
	@Column(name="roomDescription")
	private String roomDescription;
	
	@Lob
	@Column(name="roomImage")
	private byte[] roomImage;
	
	@Column(name="bookedStatus")
	private boolean bookedStatus;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="facility_id")
	private RoomFacility facility;

	public Room() {
		super();
	}

	public Room(String roomType, String bedType, String roomPrice, String roomDescription, byte[] roomImage,
			boolean bookedStatus, RoomFacility facility) {
		super();
		this.roomType = roomType;
		this.bedType = bedType;
		this.roomPrice = roomPrice;
		this.roomDescription = roomDescription;
		this.roomImage = roomImage;
		this.bookedStatus = bookedStatus;
		this.facility = facility;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public String getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(String roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getRoomDescription() {
		return roomDescription;
	}

	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}

	public byte[] getRoomImage() {
		return roomImage;
	}

	public void setRoomImage(byte[] roomImage) {
		this.roomImage = roomImage;
	}

	public boolean isBookedStatus() {
		return bookedStatus;
	}

	public void setBookedStatus(boolean bookedStatus) {
		this.bookedStatus = bookedStatus;
	}

	public RoomFacility getFacility() {
		return facility;
	}

	public void setFacility(RoomFacility facility) {
		this.facility = facility;
	}

	
	

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomType=" + roomType + ", bedType=" + bedType + ", roomPrice=" + roomPrice
				+ ", roomDescription=" + roomDescription + ", roomImage=" + Arrays.toString(roomImage)
				+ ", bookedStatus=" + bookedStatus + ", facility=" + facility + "]";
	}


	
	

	
	
	
	
	

}
