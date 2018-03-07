package com.epam.online.test.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.online.test.dao.entity.Rooms;

@Repository
public interface RoomsRepository extends CrudRepository<Rooms, Long> {
	
	List<Rooms> findAll();
	
	Rooms findOneByRoomId(String roomId);
}
