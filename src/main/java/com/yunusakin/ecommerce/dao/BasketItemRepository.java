package com.yunusakin.ecommerce.dao;

import com.yunusakin.ecommerce.model.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface BasketItemRepository extends JpaRepository<BasketItem, Integer> {



   // @Query(value = "select PRODUCT_ID, sum(quantity) as quantity,sum(TOTAL_BALANCE) as totalBalance, from Basket group by PRODUCT_ID",nativeQuery = true)
  //  List<BasketItem> getProductBy();


}
