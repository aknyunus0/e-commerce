package com.yunusakin.ecommerce.controller;

import com.yunusakin.ecommerce.dao.BasketRepository;
import com.yunusakin.ecommerce.dao.ProductRepository;
import com.yunusakin.ecommerce.model.Basket;
import com.yunusakin.ecommerce.model.Product;
import com.yunusakin.ecommerce.model.RequestBasket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class orderController {
    @Autowired
    BasketRepository BasketRepo;
    @RequestMapping("/order")
    public String homePage(){
        return "order";
    }

    @RequestMapping(value = "/order",method = RequestMethod.GET)
    public ModelAndView getAllBasket() {
        ModelAndView mv = new ModelAndView("index");
        List<Basket> basket = BasketRepo.getProductBy();
        mv.addObject("Basket",basket);
        mv.setViewName("order");
        return mv;
    }
}