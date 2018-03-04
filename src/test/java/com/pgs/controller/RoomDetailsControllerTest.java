package com.pgs.controller;

import static org.mockito.Mockito.when;

import java.math.BigDecimal;
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

import com.pgs.dto.RoomDetailsDTO;
import com.pgs.service.RoomDetailsService;
import com.pgs.service.responses.RoomDetailsResponse;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RoomDetailsController.class, secure = false)
public class RoomDetailsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RoomDetailsService roomService;

	@Before
	public void setUp() {
		
	}
	
	@After
	public void tearDown() {
		
	}

	@Test
	public void testGetAllProducts() throws Exception {

		RoomDetailsResponse productResponse = createMockProductResponse();
		Mockito.doReturn(productResponse).when(roomService).getAllRoomDetails();

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/auth/v1/products").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{\"success\":true,\"message\":SUCCESS,\"products\":[{\"productId\":1230,\"productName\":\"Nokia Mobile\",\"price\":1000,\"category\":\"Electronics\"}]}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}
	
	@Test
	public void testGetAllProductsWithException() throws Exception {

		when(roomService.getAllRoomDetails()).thenThrow(new RuntimeException());

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/auth/v1/products").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{\"success\":false,\"message\":null,\"products\":null}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}


	private RoomDetailsResponse createMockProductResponse() {
		RoomDetailsResponse productResponse = new RoomDetailsResponse();
		List<RoomDetailsDTO> products = new ArrayList<>();

		RoomDetailsDTO productDTO = new RoomDetailsDTO();

		

		products.add(productDTO);
		
		productResponse.setMessage("SUCCESS");
		productResponse.setSuccess(true);
		return productResponse;
	}

}
