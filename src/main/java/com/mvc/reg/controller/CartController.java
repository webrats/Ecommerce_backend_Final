package com.mvc.reg.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.reg.model.AddToCart;
import com.mvc.reg.services.CartService.AddToCartService;
import com.mvc.reg.services.ProductService.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class CartController {

	@Autowired
	AddToCartService addToCartService ; 
	@Autowired
	ProductService productService ;
	
	@GetMapping("/cart")
	public List<AddToCart> getCartByUser() {
		
	
		return addToCartService.getAllCartByUser(2);
	}
	@PostMapping("/cart/{product_id}")
	public ResponseEntity<?> saveCart(@RequestBody AddToCart cart ,@PathVariable long product_id) {
		cart.setProduct(productService.getProductById(product_id));
		 addToCartService.saveAddToCart(cart);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	@DeleteMapping("/cart/{id}")
	public ResponseEntity<?> deteleCartByCartId(@PathVariable long id){
		addToCartService.deteleCartByCartId(id);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
}
