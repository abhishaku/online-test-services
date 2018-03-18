package com.online.test.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.online.test.api.common.ResourceEndPoints;
import com.online.test.api.services.AssesmentQuestionsService;
import com.online.test.api.services.response.AssesmentQuestionsResponse;

@RestController
public class AssesmentQuestionsController 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(AssesmentQuestionsController.class);
	
	@Autowired
	private AssesmentQuestionsService questionsService;
	
	public AssesmentQuestionsController(final AssesmentQuestionsService questionsService) {
		LOGGER.warn("Inside contructor of : " + this.getClass().getName());
		this.questionsService = questionsService;
	}
	
	@RequestMapping(value = ResourceEndPoints.QUESTIONS_URI, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AssesmentQuestionsResponse> getAllQuestions()
	{
		AssesmentQuestionsResponse questionsResponse = new AssesmentQuestionsResponse();
		try {
			questionsResponse = questionsService.getAllAssesmentQuestions();
		} catch (Exception ex) {
			//roomDetails.setSuccess(false);
			LOGGER.error("Error while fetching Details from product Service:  ", ex.getMessage(), ex);
			return new ResponseEntity<>(questionsResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(questionsResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = ResourceEndPoints.QUESTION, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AssesmentQuestionsResponse> getQuestions()
	{
		AssesmentQuestionsResponse questionsResponse = new AssesmentQuestionsResponse();
		try {
			questionsResponse = questionsService.getAllAssesmentQuestions();
		} catch (Exception ex) {
			//roomDetails.setSuccess(false);
			LOGGER.error("Error while fetching Details from product Service:  ", ex.getMessage(), ex);
			return new ResponseEntity<>(questionsResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(questionsResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = ResourceEndPoints.QUESTION_DETAILS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AssesmentQuestionsResponse> getQuestionDetailsById(@PathVariable("questionId") String questionId, @RequestHeader HttpHeaders headers)
	{
		AssesmentQuestionsResponse questionsResponse = new AssesmentQuestionsResponse();
		if(!headers.get("Client-Type").get(0).toString().equals("web"))
		{
			LOGGER.error("Missing Header...");
			questionsResponse.setMessage("Missing Client Type Header..");
			return new ResponseEntity<>(questionsResponse, HttpStatus.UNAUTHORIZED);
		}
		
		
		try {
			questionsResponse = questionsService.getQuestionDetails(questionId);
		} catch (Exception ex) {
			//roomDetails.setSuccess(false);
			LOGGER.error("Error while fetching Details from product Service:  ", ex.getMessage(), ex);
			return new ResponseEntity<>(questionsResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(questionsResponse, HttpStatus.OK);
	}

}
