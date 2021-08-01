package com.mvc.reg.services.ProductService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mvc.reg.model.Products;

@Service
public interface ProductServiceInterface {

	List<Products> getAllProduct() ;
	public void saveProduct(Products product);
	public Products getProductById(long id) ;
}


