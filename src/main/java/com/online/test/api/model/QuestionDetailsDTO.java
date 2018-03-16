package com.online.test.api.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class QuestionDetailsDTO {

	/*below annotation is used to map the DTO field 
	 with input request in case post/put request.
	 * 
	 */
	@JsonProperty("questionId")
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
