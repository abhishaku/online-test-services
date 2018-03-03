package com.pgs.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.pgs.dao.entity.Product;
import com.pgs.dto.RoomDetailsDTO;
import com.pgs.exception.RequestException;
import com.pgs.repository.ProductRepository;
import com.pgs.service.RoomDetailsService;
import com.pgs.service.responses.RoomDetailsResponse;

@Service
public class RoomDetailsServiceImpl implements RoomDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoomDetailsServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	@Override
	public RoomDetailsResponse getAllRoomDetails() {
		
		RoomDetailsResponse productResponse = new RoomDetailsResponse();
		List<RoomDetailsDTO> products = new ArrayList<>();

		List<Product> productsList = productRepository.findAll();

		if (CollectionUtils.isEmpty(productsList)) {
			LOGGER.info("No Data available in product repository");
			productResponse.setMessage("No Prodcuts Found");
			productResponse.setSuccess(true);
			productResponse.setProducts(products);
			return productResponse;
		}

		productsList.forEach(product -> {
			RoomDetailsDTO productDTO = mapProductToProductDTO(product);
			products.add(productDTO);
		});
		
		productResponse.setMessage("SUCCESS");
		productResponse.setSuccess(true);
		productResponse.setProducts(products);
		return productResponse;
	}

	private RoomDetailsDTO mapProductToProductDTO(Product product) {

		RoomDetailsDTO productDTO = new RoomDetailsDTO();

		productDTO.setProductId(product.getId());
		productDTO.setProductName(product.getProductName());
		productDTO.setPrice(product.getPrice());
		productDTO.setCategory(product.getCategory());
		productDTO.setDescription(product.getDescription());
		return productDTO;
	}

	@Override
	public void createProduct(RoomDetailsDTO productDTO) {
		
		Product product = buildProduct(productDTO);
		productRepository.save(product);
	}

	private Product buildProduct(RoomDetailsDTO productDTO) {

		if (productDTO == null) {
			throw new RequestException("Unable to add product as productDTO is null");
		}

		final Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
		Product product = new Product();

		if (StringUtils.isEmpty(productDTO.getProductName())) {
			throw new RequestException("Product name cannot be empty");
		} else {
			Product existing = productRepository.findOneByProductNameIgnoreCase(productDTO.getProductName());
			if(existing != null) {
				throw new RequestException("Product name cannot be duplicate");
			}else {
				product.setProductName(productDTO.getProductName());
			}
		}

		if (productDTO.getPrice() == null || productDTO.getPrice().intValue() <= 0) {
			throw new RequestException("Product price cannot be null or zero or negetive");
		} else {
			product.setPrice(productDTO.getPrice());
		}

		if (StringUtils.isEmpty(productDTO.getCategory())) {
			throw new RequestException("Product category cannot be empty");
		} else {
			product.setCategory(productDTO.getCategory());
		}

		if (StringUtils.isEmpty(productDTO.getDescription())) {
			throw new RequestException("Product description cannot be empty");
		} else {
			product.setDescription(productDTO.getDescription());
		}

		product.setCreatedBy("user1");
		product.setCreationDate(currentDate);
		product.setModifiedDate(currentDate);
		product.setUpdatedBy("user2");
		return product;
	}
}
