package com.epam.online.test.dao.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
public class Product extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name="product_name" , unique = true, nullable = false)
	private String productName;
	
	@Column(name="price")
	private BigDecimal price;
	
	@Column(name="description")
	private String description;
	
	@Column(name="category")
	private String category;
	
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
}
