package com.online.test.api.services.response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.online.test.api.model.QuestionDetailsDTO;

@Component
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
