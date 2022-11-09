package com.yunusakin.ecommerce.dao;

import com.yunusakin.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
