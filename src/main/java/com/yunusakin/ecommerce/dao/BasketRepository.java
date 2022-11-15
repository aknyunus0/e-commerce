package com.yunusakin.ecommerce.dao;

import com.yunusakin.ecommerce.model.Basket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BasketRepository extends JpaRepository<Basket, Long> {


    @Query(value = "SELECT * FROM BASKET WHERE USER_ID=:userId AND status=TRUE",nativeQuery = true)
    Basket getbyUserId(@Param("userId") long userId );

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE BASKET SET SUM_BALANCE=:sumBalance WHERE id=:id",nativeQuery = true)
    void update(@Param("sumBalance") double sumBalance,@Param("id") long id);



}
