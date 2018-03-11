package com.pgs.service.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.MockitoAnnotations.initMocks;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.epam.online.test.dto.QuestionDetailsDTO;
import com.epam.online.test.exception.RequestException;
import com.epam.online.test.service.responses.AssesmentQuestionsResponse;
import com.epam.online.test.services.impl.AssesmentQuestionsServiceImpl;
import com.pgs.config.AbstractServiceTestConfig;

public class RoomDetailsServiceImplTest extends AbstractServiceTestConfig {

	@InjectMocks
	private AssesmentQuestionsServiceImpl roomService;

	@Mock
	//private ProductRepository productRepository;

	private AssesmentQuestionsResponse expectedProductResponse;

	@Before
	public void setUp() {
		initMocks(this);
		expectedProductResponse = new AssesmentQuestionsResponse();
	}

	@After
	public void tearDown() {
		expectedProductResponse = null;
	}

	@Test
	public void testCreateProduct_positive() {
		//roomService.createProduct(createProducDTOtMock());
	}
	
	@Test(expected = RequestException.class)
	public void testCreateProduct_null_product() {
		//roomService.createProduct(null);
	}
	
	@Test(expected = RequestException.class)
	public void testCreateProduct_null_productName() {
		//RoomDetailsDTO prod = createProducDTOtMock();
		//prod.setProductName(null);
		//roomService.createProduct(prod);
	}
	
	@Test(expected = RequestException.class)
	public void testCreateProduct_null_productDesc() {
		//RoomDetailsDTO prod = createProducDTOtMock();
		//prod.setDescription(null);
		//roomService.createProduct(prod);
	}
	
	@Test(expected = RequestException.class)
	public void testCreateProduct_null_productPrice() {
		//RoomDetailsDTO prod = createProducDTOtMock();
		//prod.setPrice(null);
		//roomService.createProduct(prod);
	}
	
	@Test(expected = RequestException.class)
	public void testCreateProduct_null_productCategory() {
		//RoomDetailsDTO prod = createProducDTOtMock();
		//prod.setCategory(null);
		//roomService.createProduct(prod);
	}
	
	/*@Test(expected = RequestException.class)
	public void testCreateProduct_product_exist() {
		ProductDTO prod = createProducDTOtMock();
		Product product = new Product();
		Mockito.doReturn(any(Product.class)).when(productRepository.findOneByProductNameContainingIgnoreCase(any(String.class)));
		//when(productRepository.findOneByProductNameContainingIgnoreCase(prod.getProductName())).thenReturn(any(Product.class));
		productService.createProduct(prod);
	}*/
	
	@Test
	public void testGetAllProducts() {
		List<QuestionDetailsDTO> productDTOs = new ArrayList<>();
		productDTOs.add(createProducDTOtMock());

		expectedProductResponse.setMessage("SUCCESS");
		expectedProductResponse.setSuccess(true);
		//expectedProductResponse.setProducts(productDTOs);

//		List<Product> products = new ArrayList<>();
//		Product product = createProductMock();
//		products.add(product);

		//Mockito.doReturn(products).when(productRepository).findAll();

		AssesmentQuestionsResponse originalProductResponse = roomService.getAllAssesmentQuestions();
		assertThat(expectedProductResponse.getMessage(), equalTo(originalProductResponse.getMessage()));
		assertThat(expectedProductResponse.isSuccess(), equalTo(originalProductResponse.isSuccess()));
		// assertThat(expectedProductResponse,
		// samePropertyValuesAs(originalProductResponse));

	}

	@Test
	public void testGetAllProductsWhenProductsIsEmpty() {
		expectedProductResponse.setMessage("No Prodcuts Found");
		expectedProductResponse.setSuccess(true);

		// Actual Object
		//List<Product> products = new ArrayList<>();
		//Mockito.doReturn(products).when(productRepository).findAll();

		AssesmentQuestionsResponse originalProductResponse = roomService.getAllAssesmentQuestions();

		assertThat(expectedProductResponse.getMessage(), equalTo(originalProductResponse.getMessage()));
		assertThat(expectedProductResponse.isSuccess(), equalTo(originalProductResponse.isSuccess()));
	}


	private QuestionDetailsDTO createProducDTOtMock() {
		QuestionDetailsDTO product = new QuestionDetailsDTO();
		//product.setCategory("Electronics");
		//product.setPrice(new BigDecimal(1000));
		//product.setProductId(1L);
		//product.setProductName("Nokia Mobile");
		//product.setDescription("Description");
		return product;
	}
}
