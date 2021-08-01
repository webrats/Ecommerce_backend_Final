package com.mvc.reg.services.CartService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.reg.model.AddToCart;
import com.mvc.reg.repository.AddToCartRepository;

@Service
public class AddToCartService  implements AddToCartServiceInterface{

	@Autowired
	AddToCartRepository addToCartRepository ;
	@Override
	public List<AddToCart> getAllCartByUser(long id) {
		List<AddToCart> carts = addToCartRepository.getAllCartByUser(id) ;
		return carts ;
	}
	
	public AddToCart saveAddToCart(AddToCart addToCart) {
		
		return addToCartRepository.save(addToCart);
	}

	@Override
	public void deteleCartByCartId(long id) {
		addToCartRepository.deleteById(id);
		
	}

	
}
