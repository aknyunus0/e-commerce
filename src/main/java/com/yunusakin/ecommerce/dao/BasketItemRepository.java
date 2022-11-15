package com.yunusakin.ecommerce.dao;

import com.yunusakin.ecommerce.model.Basket;
import com.yunusakin.ecommerce.model.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface BasketItemRepository extends JpaRepository<BasketItem, Integer> {


    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE BASKET_ITEM SET quantity=:quantity, TOTAL_BALANCE=:totalBalance WHERE BASKET_ID=:basketId AND product_id=:productId",nativeQuery = true)
    int saveOrUpdate(@Param("quantity") int quantity,@Param("totalBalance") double totalBalance,@Param("productId") long id,@Param("basketId") long basketId);


    @Query(value = "SELECT * FROM BASKET_ITEM WHERE BASKET_ID=:basketId AND PRODUCT_ID=:productId",nativeQuery = true)
    List<BasketItem> getbyProductId(@Param("productId") long productId,@Param("basketId") long basketId );

    @Query(value = "SELECT * FROM BASKET_ITEM WHERE BASKET_ID=:basketId",nativeQuery = true)
    List<BasketItem> getbyBasketId(@Param("basketId") long basketId );

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE BASKET_ITEM SET quantity=:quantity,TOTAL_BALANCE=:totalBalance WHERE id=:id ",nativeQuery = true)
    void update(@Param("quantity") int quantity,@Param("totalBalance") double totalBalance,@Param("id") long id);
//@Param("quantity") int quantity,@Param("totalBalance") double totalBalance,@Param("productId") long id


}
