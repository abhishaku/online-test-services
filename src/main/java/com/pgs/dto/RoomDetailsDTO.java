package com.pgs.dto;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class RoomDetailsDTO {

	private String roomId;

	private String roomDescription;

	private BigDecimal roomPrice;

	@ApiModelProperty(notes = "Room ID", required = true)
	public String getRoomId() {
		return this.roomId;
	}

	public void setRoomId(final String roomId) {
		this.roomId = roomId;
	}
	
	@ApiModelProperty(notes = "Room Description", required = true)
	public String getRoomDescription() {
		return this.roomDescription;
	}

	public void setRoomDescription(final String roomDescription) {
		this.roomDescription = roomDescription;
	}
	
	@ApiModelProperty(notes = "Room Price", required = true)
	public BigDecimal getRoomPrice() {
		return this.roomPrice;
	}

	public void setRoomPrice(final BigDecimal roomPrice) {
		this.roomPrice = roomPrice;
	}

	
}
