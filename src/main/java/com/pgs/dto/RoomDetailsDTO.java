package com.pgs.dto;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class RoomDetailsDTO {

	private Long productId;

	private String productName;

	private BigDecimal price;

	private String category;
	
	private String description;

	@ApiModelProperty(notes = "Unique Product ID", required = true)
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@ApiModelProperty(notes = "Name of the product", required = true)
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@ApiModelProperty(notes = "Price of the product", required = true)
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@ApiModelProperty(notes = "Category of the product", required = true)
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@ApiModelProperty(notes = "Product description", required = true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
