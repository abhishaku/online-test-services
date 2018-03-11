package com.epam.online.test.dao.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questions_details")
public class Questions {
	
	@Id
	@Column(name = "question_id" , unique = true, nullable = false)
	private String questionId;
	
	@Column(name = "question_description")
	private String questionDescription;

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}		
}
