package com.pgs.service;

import com.pgs.dto.RoomDetailsDTO;
import com.pgs.service.responses.RoomDetailsResponse;

public interface RoomDetailsService {
	
	RoomDetailsResponse getAllRoomDetails();
	
	void createProduct(RoomDetailsDTO product);

}
