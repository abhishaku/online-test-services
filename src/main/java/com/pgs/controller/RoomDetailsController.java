package com.pgs.controller;

import java.net.HttpURLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pgs.dto.RoomDetailsDTO;
import com.pgs.service.RoomDetailsService;
import com.pgs.service.responses.RoomDetailsResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class RoomDetailsController 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(RoomDetailsController.class);
	
	@Autowired
	private RoomDetailsService roomService;
	
	public RoomDetailsController(final RoomDetailsService productService) {
		LOGGER.warn("Inside contructor of : " + this.getClass().getName());
		//this.productService = productService;
	}
	
	@RequestMapping(value = "/v1/rooms", method = RequestMethod.GET)
	public ResponseEntity<RoomDetailsResponse> getRoomDetails()
	{
		RoomDetailsResponse roomDetails = new RoomDetailsResponse();
		try {
			roomDetails = roomService.getAllRoomDetails();
		} catch (Exception ex) {
			roomDetails.setSuccess(false);
			LOGGER.error("Error while fetching Details from product Service:  ", ex.getMessage(), ex);
			return new ResponseEntity<>(roomDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(roomDetails, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/v1/room/{id}", method = RequestMethod.GET)
	public ResponseEntity<RoomDetailsResponse> getRoomDetailsById()
	{
		RoomDetailsResponse productResponse = new RoomDetailsResponse();
		try {
			productResponse = roomService.getAllRoomDetails();
		} catch (Exception ex) {
			productResponse.setSuccess(false);
			LOGGER.error("Error while fetching Details from product Service:  ", ex.getMessage(), ex);
			return new ResponseEntity<>(productResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(productResponse, HttpStatus.OK);
	}

}
