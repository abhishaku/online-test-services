package com.epam.online.test.services;

import com.epam.online.test.service.responses.AssesmentQuestionsResponse;

public interface AssesmentQuestionsService {
	
	AssesmentQuestionsResponse getAllAssesmentQuestions();
	
	AssesmentQuestionsResponse getQuestionDetails(String questionId);
}
