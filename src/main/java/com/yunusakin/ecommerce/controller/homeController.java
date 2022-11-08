package com.yunusakin.ecommerce.controller;

import com.yunusakin.ecommerce.dao.BasketRepository;
import com.yunusakin.ecommerce.dao.ProductRepository;
import com.yunusakin.ecommerce.model.Basket;
import com.yunusakin.ecommerce.model.Product;
import com.yunusakin.ecommerce.model.RequestBasket;
import com.yunusakin.ecommerce.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class homeController {
    @Autowired
    ProductRepository ProductRepo;
    @Autowired
    BasketService serviceBasket;

    @RequestMapping("/")
    public String homePage(){
        return "home";
    }

    @RequestMapping("/getProduct")
    public ModelAndView getAllProduct() {
        ModelAndView mv = new ModelAndView("index");
       List<Product> product = ProductRepo.findAll();
        mv.addObject("product",product);
        mv.setViewName("getProduct");
        return mv;
    }

   // @PostMapping("/addBasket" )
    @RequestMapping(value = "/addBasket",method = RequestMethod.POST)
    public String addJournalEntry(RequestBasket add) {


        serviceBasket.saveBasket(add);
        return "getProduct";
    }






}
