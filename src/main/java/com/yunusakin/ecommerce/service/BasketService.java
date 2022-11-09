package com.yunusakin.ecommerce.service;

import com.yunusakin.ecommerce.dao.BasketRepository;
import com.yunusakin.ecommerce.dao.ProductRepository;
import com.yunusakin.ecommerce.model.Basket;
import com.yunusakin.ecommerce.model.Product;
import com.yunusakin.ecommerce.model.RequestBasket;
import org.springframework.stereotype.Service;

@Service
public class BasketService {


    BasketRepository basketRepository;
    ProductRepository ProductRepo;

    public BasketService(BasketRepository basketRepo){
        this.basketRepository=basketRepo;

    }

    public String saveBasket(RequestBasket request){
        Basket basket=new Basket();
        basket.setProduct(request.getProduct());
        basket.setQuantity(request.getQuantity());
        basket.setTotalBalance(request.getTotalBalance());
        basketRepository.save(basket);
        return "succes";
    }

}
