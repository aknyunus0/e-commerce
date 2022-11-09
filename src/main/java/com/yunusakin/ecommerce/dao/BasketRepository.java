package com.yunusakin.ecommerce.dao;

import com.yunusakin.ecommerce.model.Basket;
import com.yunusakin.ecommerce.model.RequestBasket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface BasketRepository extends JpaRepository<Basket, Integer> {



    @Query(value = "select PRODUCT_ID, sum(quantity) as quantity,sum(TOTAL_BALANCE) as totalBalance, from Basket group by PRODUCT_ID",nativeQuery = true)
    List<Basket> getProductBy();




}
