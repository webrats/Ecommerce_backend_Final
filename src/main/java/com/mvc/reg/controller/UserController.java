package com.mvc.reg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.reg.config.CustomUserDetailsService;
import com.mvc.reg.model.AddToCart;
import com.mvc.reg.repository.AddToCartRepository;
import com.mvc.reg.services.CartService.AddToCartService;

import dto.UserDto;

@RestController
@CrossOrigin(origins = { "localhost:4200"}, allowedHeaders={"Accept"})
public class UserController {

	@Autowired CustomUserDetailsService customUserDetailsService ;
	@Autowired
	AddToCartService addToCart ;
	
	
	@GetMapping("user/hellouser")
	public List<AddToCart> helloUser() {
		List<AddToCart> carts = addToCart.getAllCartByUser(1);
		for(int i =0 ;i<carts.size() ;i++) {
			System.out.println(carts.get(i).getProduct().getName());
		}
		
		return addToCart.getAllCartByUser(1) ;
	}
	
	@GetMapping("/helloadmin")
	public String helloAdmin() {
		return "Hello Admin !";
		
	}

}
