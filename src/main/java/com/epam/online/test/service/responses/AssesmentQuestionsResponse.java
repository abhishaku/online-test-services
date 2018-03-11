package com.epam.online.test.service.responses;

import java.util.ArrayList;
import java.util.List;

import com.epam.online.test.model.QuestionDetailsDTO;

public class AssesmentQuestionsResponse extends BaseResponse {

	List<QuestionDetailsDTO> questionDetailsData;

	public List<QuestionDetailsDTO> getQuestionsDetails() {
		if (questionDetailsData == null) {
			questionDetailsData = new ArrayList<>();
		}
		return questionDetailsData;
	}
	

	public void setQuestionDetails(final List<QuestionDetailsDTO> questionDetailsData) {
		this.questionDetailsData = questionDetailsData;
	}

}
