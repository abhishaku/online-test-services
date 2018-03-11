package com.epam.online.test.services;

import com.epam.online.test.service.responses.RoomDetailsResponse;

public interface RoomDetailsService {
	
	RoomDetailsResponse getAllRoomDetails();
	
	RoomDetailsResponse getRoomDetails(String roomId);
}
