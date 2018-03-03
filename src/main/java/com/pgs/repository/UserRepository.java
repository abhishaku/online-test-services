package com.pgs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pgs.dao.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findOneByUserName(String userName);

}