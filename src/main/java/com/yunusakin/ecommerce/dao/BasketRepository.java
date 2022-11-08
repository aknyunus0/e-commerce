package com.yunusakin.ecommerce.dao;

import com.yunusakin.ecommerce.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Integer> {
}
