package com.yunusakin.ecommerce.service;

import com.yunusakin.ecommerce.dao.BasketItemRepository;
import com.yunusakin.ecommerce.dao.ProductRepository;
import com.yunusakin.ecommerce.model.BasketItem;
import com.yunusakin.ecommerce.model.RequestBasket;
import org.springframework.stereotype.Service;

@Service
public class BasketService {


    BasketItemRepository basketItemRepository;
    ProductRepository ProductRepo;

    public BasketService(BasketItemRepository basketRepo){
        this.basketItemRepository =basketRepo;

    }

    public String saveBasket(RequestBasket request){
        BasketItem basketItem =new BasketItem();
        basketItem.setProduct(request.getProduct());
        basketItem.setQuantity(request.getQuantity());
        basketItem.setTotalBalance(request.getTotalBalance());
        basketItemRepository.save(basketItem);
        return "succes";
    }

}
