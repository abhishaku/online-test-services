package com.online.test.services;

import com.online.test.service.responses.AssesmentQuestionsResponse;

public interface AssesmentQuestionsService {
	
	AssesmentQuestionsResponse getAllAssesmentQuestions();
	
	AssesmentQuestionsResponse getQuestionDetails(String questionId);
}
