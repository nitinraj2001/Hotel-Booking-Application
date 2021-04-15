package com.nitinraj.hotelbooking.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nitinraj.hotelbooking.model.Room;

@Service
public interface RoomService {
	
	public void saveRoom(Room theRoom);
	
	public List<Room> getAvailableRooms();
	
	public Room getRoom(int RoomNo);

}
