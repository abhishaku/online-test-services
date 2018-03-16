package com.test.controller;

import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.online.test.api.controller.AssesmentQuestionsController;
import com.online.test.api.model.QuestionDetailsDTO;
import com.online.test.api.services.AssesmentQuestionsService;
import com.online.test.api.services.response.AssesmentQuestionsResponse;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AssesmentQuestionsController.class, secure = false)
public class RoomDetailsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AssesmentQuestionsService roomService;

	@Before
	public void setUp() {
		
	}
	
	@After
	public void tearDown() {
		
	}

	@Test
	public void testGetAllProducts() throws Exception {

		AssesmentQuestionsResponse productResponse = createMockProductResponse();
		Mockito.doReturn(productResponse).when(roomService).getAllAssesmentQuestions();

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/auth/v1/products").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{\"success\":true,\"message\":SUCCESS,\"products\":[{\"productId\":1230,\"productName\":\"Nokia Mobile\",\"price\":1000,\"category\":\"Electronics\"}]}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void testGetAllProductsWithException() throws Exception {

		when(roomService.getAllAssesmentQuestions()).thenThrow(new RuntimeException());

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/auth/v1/products").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{\"success\":false,\"message\":null,\"products\":null}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}


	private AssesmentQuestionsResponse createMockProductResponse() {
		AssesmentQuestionsResponse productResponse = new AssesmentQuestionsResponse();
		List<QuestionDetailsDTO> products = new ArrayList<>();

		QuestionDetailsDTO productDTO = new QuestionDetailsDTO();

		

		products.add(productDTO);
		
		productResponse.setMessage("SUCCESS");
		productResponse.setSuccess(true);
		return productResponse;
	}

}
