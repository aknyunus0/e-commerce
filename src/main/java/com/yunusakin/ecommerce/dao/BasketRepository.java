package com.yunusakin.ecommerce.dao;

import com.yunusakin.ecommerce.model.Basket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface BasketRepository extends JpaRepository<Basket, Long> {


    @Query(value = "SELECT * FROM BASKET WHERE USER_ID=:userId AND status=TRUE",nativeQuery = true)
    Basket getbyUserId(@Param("userId") long userId );
    @Query(value = "SELECT * FROM BASKET WHERE USER_ID=:userId AND status=FALSE",nativeQuery = true)
    List<Basket> getOrderbyUserId(@Param("userId") long userId );

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE BASKET SET SUM_BALANCE=:sumBalance WHERE id=:id",nativeQuery = true)
    void update(@Param("sumBalance") double sumBalance,@Param("id") long id);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE BASKET SET status=:status WHERE id=:basketId AND user_id=:userId",nativeQuery = true)
    void updateStatus(@Param("status") boolean status,@Param("basketId") long id,@Param("userId") long userId);



}
