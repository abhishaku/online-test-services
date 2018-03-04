package com.pgs.service.responses;

import java.util.ArrayList;
import java.util.List;

import com.pgs.dto.RoomDetailsDTO;

public class RoomDetailsResponse extends BaseResponse {

	List<RoomDetailsDTO> roomDetails;

	public List<RoomDetailsDTO> getRoomsDetails() {
		if (roomDetails == null) {
			roomDetails = new ArrayList<>();
		}
		return roomDetails;
	}
	

	public void setRoomDetails(List<RoomDetailsDTO> roomDetails) {
		this.roomDetails = roomDetails;
	}

}
