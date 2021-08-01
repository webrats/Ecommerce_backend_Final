package com.mvc.reg.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mvc.reg.model.AddToCart;


@Repository
public interface AddToCartRepository extends JpaRepository<AddToCart,Long> {

	@Query("select cart from AddToCart cart where cart.user_id =:id")
	List<AddToCart>getAllCartByUser(@Param("id") long id);
	
	
	@Query("Select sum(addCart.price) FROM AddToCart addCart WHERE addCart.user_id=:user_id")
	double getTotalAmountByUserId(@Param("user_id")Long user_id);
	
	@Query("Select addCart  FROM AddToCart addCart WHERE addCart.user_id=:user_id")
	List<AddToCart> getCartByuserId(@Param("user_id")Long user_id);
	
	@Query("Select addCart  FROM AddToCart addCart ")
	Optional<AddToCart> getCartByuserIdtest();
	
	@Query("Select addCart  FROM AddToCart addCart WHERE addCart.product.id= :product_id and addCart.user_id=:user_id")
	Optional<AddToCart> getCartByProductIdAnduserId(@Param("user_id")Long user_id,@Param("product_id")Long product_id);
	
	@Modifying
    @Transactional
	@Query("DELETE  FROM AddToCart addCart WHERE addCart.id =:cart_id   and addCart.user_id=:user_id")
	void deleteCartByIdAndUserId(@Param("user_id")Long user_id,@Param("cart_id")Long cart_id);
	
	@Modifying
    @Transactional
	@Query("DELETE  FROM AddToCart addCart WHERE   addCart.user_id=:user_id")
	void deleteAllCartByUserId(@Param("user_id")Long user_id);
	
	@Modifying
    @Transactional
	@Query("DELETE  FROM AddToCart addCart WHERE addCart.user_id=:user_id")
	void deleteAllCartUserId(@Param("user_id")Long user_id);
	@Modifying
    @Transactional
	@Query("update AddToCart addCart set addCart.qty=:qty,addCart.price=:price WHERE addCart.id=:cart_id")
	void updateQtyByCartId(@Param("cart_id")Long cart_id,@Param("price")double price,@Param("qty")Integer qty);
}
