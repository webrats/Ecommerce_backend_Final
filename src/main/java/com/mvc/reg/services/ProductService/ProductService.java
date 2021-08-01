package com.mvc.reg.services.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.reg.model.Products;
import com.mvc.reg.repository.ProductsRepository;

@Service
public class ProductService implements ProductServiceInterface {

	@Autowired
	ProductsRepository productsRep ;
	@Override
	public List<Products> getAllProduct() {
	
		return productsRep.findAll();
	}
	@Override
	public void saveProduct(Products product) {
		
		productsRep.save(product) ;
	}
	@Override
	public Products getProductById(long id) {
		
		return productsRep.getById(id);
	}
	
	

}
