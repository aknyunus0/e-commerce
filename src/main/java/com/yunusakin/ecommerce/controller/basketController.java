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

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Controller
public class basketController {
    @Autowired
    BasketService serviceBasket;
    @Autowired
    BasketItemRepository BasketItemRepo;
    @Autowired
    BasketRepository basketRepository;
    @RequestMapping("/basket")
    public String homePage(){
        return "basket";
    }

    @RequestMapping(value = "/basket/up/{id}",method = RequestMethod.POST)
    public ModelAndView setBasketUpdate(@PathVariable(value = "id" )int id, RequestBasketItem request){
        if(request.getQuantity()==0)
        {
            serviceBasket.delete(id);
            serviceBasket.updateSumBalanceInBasket();
            return getAllBasket();
        }
        serviceBasket.updateByid(id,request);
        serviceBasket.updateSumBalanceInBasket();
        return getAllBasket();
    }

    @RequestMapping(value = "/basket/del/{id}",method = RequestMethod.POST)
    public ModelAndView delBasketItem(@PathVariable(value = "id" )int id){
        serviceBasket.delete(id);
        serviceBasket.updateSumBalanceInBasket();

        return getAllBasket();
    }

    @RequestMapping(value = "/basket",method = RequestMethod.GET)
    public ModelAndView getAllBasket() {
        ModelAndView mv = new ModelAndView("index");
        Basket basket= basketRepository.getbyUserId(serviceBasket.getUserId());
        List<BasketItem> basketItems=new ArrayList<>();
        if(!(ObjectUtils.isEmpty(basket))){
            basketItems = BasketItemRepo.getbyBasketId(basket.getId());
        }
        mv.addObject("BasketItem", basketItems);
        mv.setViewName("basket");
        return mv;
    }

    @RequestMapping(value = "/basket/createOrder/{userId}/{basketId}",method = RequestMethod.POST)
    public ModelAndView createOrder(@PathVariable(value = "basketId" ) long basketId ,@PathVariable(value = "userId" ) long userId  ){
       serviceBasket.updateStatusBasket(false,basketId,userId);
       return getAllBasket();

    }

}
