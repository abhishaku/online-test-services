package com.pgs.service.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.MockitoAnnotations.initMocks;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.epam.online.test.dao.entity.Product;
import com.epam.online.test.dto.RoomDetailsDTO;
import com.epam.online.test.exception.RequestException;
import com.epam.online.test.service.responses.RoomDetailsResponse;
import com.epam.online.test.services.impl.RoomDetailsServiceImpl;
import com.pgs.config.AbstractServiceTestConfig;

public class RoomDetailsServiceImplTest extends AbstractServiceTestConfig {

	@InjectMocks
	private RoomDetailsServiceImpl roomService;

	@Mock
	//private ProductRepository productRepository;

	private RoomDetailsResponse expectedProductResponse;

	@Before
	public void setUp() {
		initMocks(this);
		expectedProductResponse = new RoomDetailsResponse();
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
		List<RoomDetailsDTO> productDTOs = new ArrayList<>();
		productDTOs.add(createProducDTOtMock());

		expectedProductResponse.setMessage("SUCCESS");
		expectedProductResponse.setSuccess(true);
		//expectedProductResponse.setProducts(productDTOs);

		List<Product> products = new ArrayList<>();
		Product product = createProductMock();
		products.add(product);

		//Mockito.doReturn(products).when(productRepository).findAll();

		RoomDetailsResponse originalProductResponse = roomService.getAllRoomDetails();
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

		RoomDetailsResponse originalProductResponse = roomService.getAllRoomDetails();

		assertThat(expectedProductResponse.getMessage(), equalTo(originalProductResponse.getMessage()));
		assertThat(expectedProductResponse.isSuccess(), equalTo(originalProductResponse.isSuccess()));
	}

	private Product createProductMock() {
		Product product = new Product();
		product.setCategory("Electronics");
		product.setPrice(new BigDecimal(1000));
		product.setId(1L);
		product.setProductName("Nokia Mobile");
		return product;
	}

	private RoomDetailsDTO createProducDTOtMock() {
		RoomDetailsDTO product = new RoomDetailsDTO();
		//product.setCategory("Electronics");
		//product.setPrice(new BigDecimal(1000));
		//product.setProductId(1L);
		//product.setProductName("Nokia Mobile");
		//product.setDescription("Description");
		return product;
	}
}
