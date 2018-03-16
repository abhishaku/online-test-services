package com.online.test.api.services;

import com.online.test.api.services.response.AssesmentQuestionsResponse;

public interface AssesmentQuestionsService {
	
	AssesmentQuestionsResponse getAllAssesmentQuestions();
	
	AssesmentQuestionsResponse getQuestionDetails(String questionId);
}
