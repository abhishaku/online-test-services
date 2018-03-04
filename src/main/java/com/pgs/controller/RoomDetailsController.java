package com.pgs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pgs.ResourcesURI;
import com.pgs.service.RoomDetailsService;
import com.pgs.service.responses.RoomDetailsResponse;

@RestController
public class RoomDetailsController 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(RoomDetailsController.class);
	
	@Autowired
	private RoomDetailsService roomService;
	
	public RoomDetailsController(final RoomDetailsService roomService) {
		LOGGER.warn("Inside contructor of : " + this.getClass().getName());
		this.roomService = roomService;
	}
	
	@RequestMapping(value = ResourcesURI.ROOMS_DETAILS, method = RequestMethod.GET)
	public ResponseEntity<RoomDetailsResponse> getRoomDetails()
	{
		RoomDetailsResponse roomDetails = new RoomDetailsResponse();
		try {
			roomDetails = roomService.getAllRoomDetails();
		} catch (Exception ex) {
			//roomDetails.setSuccess(false);
			LOGGER.error("Error while fetching Details from product Service:  ", ex.getMessage(), ex);
			return new ResponseEntity<>(roomDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(roomDetails, HttpStatus.OK);
	}
	
	@RequestMapping(value = ResourcesURI.ROOM_DETAILS, method = RequestMethod.GET)
	public ResponseEntity<RoomDetailsResponse> getRoomDetailsById(@PathVariable("roomId") String roomId, @RequestHeader HttpHeaders headers)
	{
		RoomDetailsResponse roomDetails = new RoomDetailsResponse();
		if(!headers.get("Client-Type").get(0).toString().equals("web"))
		{
			LOGGER.error("Missing Header...");
			roomDetails.setMessage("Missing Client Type Header..");
			return new ResponseEntity<>(roomDetails, HttpStatus.UNAUTHORIZED);
		}
		
		
		try {
			roomDetails = roomService.getRoomDetails(roomId);
		} catch (Exception ex) {
			//roomDetails.setSuccess(false);
			LOGGER.error("Error while fetching Details from product Service:  ", ex.getMessage(), ex);
			return new ResponseEntity<>(roomDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(roomDetails, HttpStatus.OK);
	}

}
