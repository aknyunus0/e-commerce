package com.yunusakin.ecommerce.controller;

import com.yunusakin.ecommerce.dao.BasketItemRepository;
import com.yunusakin.ecommerce.dao.BasketRepository;
import com.yunusakin.ecommerce.model.Basket;
import com.yunusakin.ecommerce.model.BasketItem;
import com.yunusakin.ecommerce.model.RequestBasketItem;
import com.yunusakin.ecommerce.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class orderController {

    @Autowired
    BasketService serviceBasket;
    @Autowired
    BasketItemRepository BasketItemRepo;
    @Autowired
    BasketRepository basketRepository;

    @RequestMapping(value = "/order",method = RequestMethod.GET)
    public ModelAndView getAllOrder() {
        ModelAndView mv = new ModelAndView("index");
        List <Basket> basketList= basketRepository.getOrderbyUserId(serviceBasket.getUserId());
        Map<String,List<BasketItem>> orderList=new HashMap<>();
        String ordername="ORDER #";
        int i=1;
        for (Basket basket: basketList
             ) {
            List<BasketItem> basketItems=basketItems = BasketItemRepo.getbyBasketId(basket.getId());
            orderList.put(ordername+i,basketItems);
            i++;
        }
        mv.addObject("OrderList", orderList);
        mv.setViewName("order");
        return mv;
    }



}
