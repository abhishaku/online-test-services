package com.online.test.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.online.test.dao.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findOneByUserName(String userName);

}