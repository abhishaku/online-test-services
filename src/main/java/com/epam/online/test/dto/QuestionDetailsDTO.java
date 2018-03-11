package com.epam.online.test.dto;


import io.swagger.annotations.ApiModelProperty;

public class QuestionDetailsDTO {

	private String questionId;

	private String questionDescription;

	@ApiModelProperty(notes = "Question ID", required = true)
	public String getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(final String questionId) {
		this.questionId = questionId;
	}
	
	@ApiModelProperty(notes = "Question Description", required = true)
	public String getQuestionDescription() {
		return this.questionDescription;
	}

	public void setQuestionDescription(final String questionDescription) {
		this.questionDescription = questionDescription;
	}	
}
