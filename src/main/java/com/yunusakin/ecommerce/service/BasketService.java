package com.yunusakin.ecommerce.service;

import com.yunusakin.ecommerce.dao.BasketRepository;
import com.yunusakin.ecommerce.model.Basket;
import com.yunusakin.ecommerce.model.Product;
import com.yunusakin.ecommerce.model.RequestBasket;
import org.springframework.stereotype.Service;

@Service
public class BasketService {


    BasketRepository basketRepository;

    public BasketService(BasketRepository basketRepo){
        this.basketRepository=basketRepo;

    }

    public String saveBasket(RequestBasket request){
        Basket basket=new Basket();
        basket.setProduct(request.getProduct());
        basket.setNumberOfProduct(request.getNumberOfProduct());
        basket.setTotalBalance(request.getTotalBalance());
        basketRepository.save(basket);
        return "succes";
    }

}
