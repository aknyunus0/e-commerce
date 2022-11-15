package com.yunusakin.ecommerce.controller;

import com.yunusakin.ecommerce.dao.BasketItemRepository;
import com.yunusakin.ecommerce.dao.BasketRepository;
import com.yunusakin.ecommerce.model.Basket;
import com.yunusakin.ecommerce.model.BasketItem;
import com.yunusakin.ecommerce.model.RequestBasketItem;
import com.yunusakin.ecommerce.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class orderController {
    @Autowired
    BasketService serviceBasket;
    @Autowired
    BasketItemRepository BasketItemRepo;
    @Autowired
    BasketRepository basketRepository;
    @RequestMapping("/order")
    public String homePage(){
        return "order";
    }

    @RequestMapping(value = "/order/{id}",method = RequestMethod.POST)
    public ModelAndView setBasketUpdate(@PathVariable(value = "id" )int id, RequestBasketItem request){
        serviceBasket.updateByid(id,request);
        serviceBasket.updateSumBalanceInBasket();


        return getAllBasket();
    }

    @RequestMapping(value = "/order",method = RequestMethod.GET)
    public ModelAndView getAllBasket() {
       ModelAndView mv = new ModelAndView("index");
        Basket basket= basketRepository.getbyUserId(serviceBasket.getUserId());
        List<BasketItem> basketItems = BasketItemRepo.getbyBasketId(basket.getId());
        mv.addObject("BasketItem", basketItems);
        mv.setViewName("order");
        return mv;
    }

}
