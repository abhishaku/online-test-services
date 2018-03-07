package com.epam.online.test.services.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.online.test.dao.entity.Rooms;
import com.epam.online.test.dto.RoomDetailsDTO;
import com.epam.online.test.repository.RoomsRepository;
import com.epam.online.test.service.responses.RoomDetailsResponse;
import com.epam.online.test.services.RoomDetailsService;

@Service
public class RoomDetailsServiceImpl implements RoomDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoomDetailsServiceImpl.class);

	@Autowired
	private RoomsRepository roomsRepository;

	@Override
	public RoomDetailsResponse getAllRoomDetails() {
		
		RoomDetailsResponse roomResponse = new RoomDetailsResponse();
		List<RoomDetailsDTO> rooms = new ArrayList<>();

		List<Rooms> roomsDetails = roomsRepository.findAll();

		if (CollectionUtils.isEmpty(roomsDetails)) {
			LOGGER.info("No Data available in room repository");
			roomResponse.setMessage("No room Found");
		}
		
		roomsDetails.forEach(roomData -> {
			RoomDetailsDTO roomsDTO = this.mapProductToProductDTO(roomData);
			rooms.add(roomsDTO);
		});
		
		roomResponse.setMessage(rooms.size() + " Rooms are available.");
		//roomResponse.setSuccess(true);
		roomResponse.setRoomDetails(rooms);
		return roomResponse;
	}
	

	@Override
	public RoomDetailsResponse getRoomDetails(String roomId) {
		
		RoomDetailsResponse roomResponse = new RoomDetailsResponse();
		List<RoomDetailsDTO> rooms = new ArrayList<>();
		Rooms roomDetails = roomsRepository.findOneByRoomId(roomId);
		RoomDetailsDTO roomsDTO = this.mapProductToProductDTO(roomDetails);
		rooms.add(roomsDTO);
		roomResponse.setMessage("Searched room is available.");
		roomResponse.setRoomDetails(rooms);
		return roomResponse;
	}

	private RoomDetailsDTO mapProductToProductDTO(final Rooms roomData) {

		RoomDetailsDTO roomDetailsData = new RoomDetailsDTO();
		roomDetailsData.setRoomId(roomData.getRoomId());
		roomDetailsData.setRoomDescription(roomData.getRoomDescription());
		roomDetailsData.setRoomPrice(roomData.getRoomPrice());
		return roomDetailsData;	
	}
}
