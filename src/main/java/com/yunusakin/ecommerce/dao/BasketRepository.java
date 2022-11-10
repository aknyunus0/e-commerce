package com.yunusakin.ecommerce.dao;

import com.yunusakin.ecommerce.model.Basket;

import com.yunusakin.ecommerce.model.RequestBasket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Objects;

public interface BasketRepository extends JpaRepository<Basket, Long> {


    @Query(value = "SELECT PRODUCT_ID , sum(quantity),sum(TOTAL_BALANCE) FROM BASKET_ITEM GROUP BY PRODUCT_ID",nativeQuery = true)
    List<Basket> getProductBy();

}
