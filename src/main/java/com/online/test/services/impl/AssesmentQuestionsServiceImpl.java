package com.online.test.services.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.test.dao.entity.Questions;
import com.online.test.model.QuestionDetailsDTO;
import com.online.test.repository.QuestionsRepository;
import com.online.test.service.responses.AssesmentQuestionsResponse;
import com.online.test.services.AssesmentQuestionsService;

@Service
public class AssesmentQuestionsServiceImpl implements AssesmentQuestionsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssesmentQuestionsServiceImpl.class);

	@Autowired
	private QuestionsRepository questionsRepository;

	@Override
	public AssesmentQuestionsResponse getAllAssesmentQuestions() {
		
		AssesmentQuestionsResponse questionsResponse = new AssesmentQuestionsResponse();
		List<QuestionDetailsDTO> questionsDetails = new ArrayList<>();

		List<Questions> questionsData = questionsRepository.findAll();

		if (CollectionUtils.isEmpty(questionsData)) {
			LOGGER.info("No Data available in question repository");
			questionsResponse.setMessage("No question Found");
		}
		
		questionsData.forEach(questionData -> {
			QuestionDetailsDTO questionDTO = this.getMappedQuestionFromQuestionDTO(questionData);
			questionsDetails.add(questionDTO);
		});
		
		questionsResponse.setMessage(questionsData.size() + " question(s) found.");
		//roomResponse.setSuccess(true);
		questionsResponse.setQuestionDetails(questionsDetails);
		return questionsResponse;
	}
	

	@Override
	public AssesmentQuestionsResponse getQuestionDetails(final String questionId) {
		
		AssesmentQuestionsResponse questionsResponse = new AssesmentQuestionsResponse();
		List<QuestionDetailsDTO> questionsDetails = new ArrayList<>();
		Questions questions = questionsRepository.findOneByQuestionId(questionId);
		QuestionDetailsDTO questionsDTO = this.getMappedQuestionFromQuestionDTO(questions);
		questionsDetails.add(questionsDTO);
		questionsResponse.setMessage("Searched question is found.");
		questionsResponse.setQuestionDetails(questionsDetails);
		return questionsResponse;
	}

	private QuestionDetailsDTO getMappedQuestionFromQuestionDTO(final Questions questionsData) {

		QuestionDetailsDTO questionsDetailsData = new QuestionDetailsDTO();
		questionsDetailsData.setQuestionId(questionsData.getQuestionId());
		questionsDetailsData.setQuestionDescription(questionsData.getQuestionDescription());
		return questionsDetailsData;	
	}
}
