package com.pgs.service.responses;

import java.util.ArrayList;
import java.util.List;

import com.pgs.dto.RoomDetailsDTO;

public class RoomDetailsResponse extends BaseResponse {

	List<RoomDetailsDTO> roomDetails;

	public List<RoomDetailsDTO> getRoomsDetails() {
		if (roomDetails == null) {
			new ArrayList<>();
		}
		return roomDetails;
	}

	public void setProducts(List<RoomDetailsDTO> roomDetails) {
		this.roomDetails = roomDetails;
	}

}
