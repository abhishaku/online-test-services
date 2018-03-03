package com.pgs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pgs.dao.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	List<Product> findAll();
	
	Product findOneByProductNameIgnoreCase(String productName);
}
