package com.online.test.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.online.test.dao.entity.Questions;

@Repository
public interface QuestionsRepository extends CrudRepository<Questions, Long> {
	
	List<Questions> findAll();
	
	Questions findOneByQuestionId(String roomId);
}
