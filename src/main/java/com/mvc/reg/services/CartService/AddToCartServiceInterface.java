package com.mvc.reg.services.CartService;
import java.util.List;

import org.springframework.stereotype.Service;
import com.mvc.reg.model.AddToCart;


@Service
public interface AddToCartServiceInterface {

	List<AddToCart> getAllCartByUser(long id) ;
	public AddToCart saveAddToCart(AddToCart addToCart);
	public void deteleCartByCartId(long id);
	/*
	List<AddToCart> addCartbyUserIdAndProductId(long productId,long userId,int qty,double price) throws Exception;
	void updateQtyByCartId(long cartId,int qty,double price) throws Exception;
	List<AddToCart> removeCartByUserId(long cartId,long userId);
	List<AddToCart> removeAllCartByUserId(long userId);
	Boolean checkTotalAmountAgainstCart(double totalAmount,long userId);
	//List<CheckoutCart> getAllCheckoutByUserId(long userId);
	//List<CheckoutCart> saveProductsForCheckout(List<CheckoutCart> tmp)  throws Exception;
	 * */
	
	
}
