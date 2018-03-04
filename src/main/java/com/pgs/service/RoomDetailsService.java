package com.pgs.service;

import com.pgs.service.responses.RoomDetailsResponse;

public interface RoomDetailsService {
	
	RoomDetailsResponse getAllRoomDetails();
	
	RoomDetailsResponse getRoomDetails(String roomId);
}
