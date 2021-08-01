package com.mvc.reg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.reg.model.Products;
import com.mvc.reg.services.ProductService.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService productService ;
	
	@GetMapping("/load")
	public List<Products> getAllProducts(){
		List<Products> products = productService.getAllProduct() ;
		return products ;
	}
	@PostMapping
	public void saveProduct(@RequestBody Products product) {
		productService.saveProduct(product);
		
	}
}
