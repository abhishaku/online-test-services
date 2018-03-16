package com.online.test.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.online.test.api.dao.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findOneByUserName(String userName);

}