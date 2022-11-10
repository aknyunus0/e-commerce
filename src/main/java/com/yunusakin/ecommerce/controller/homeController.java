package com.yunusakin.ecommerce.controller;

import com.yunusakin.ecommerce.dao.ProductRepository;
import com.yunusakin.ecommerce.model.Product;
import com.yunusakin.ecommerce.model.RequestBasket;
import com.yunusakin.ecommerce.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

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

    //@PostMapping("/addBasket/{produc" )
    @RequestMapping(value = "/addBasket/{productId}",method = RequestMethod.POST)
    public String addBasket(@PathVariable(value="productId") Long productId, RequestBasket add) {

        Optional<Object> comment = ProductRepo.findById(productId).map(product -> {
            add.setProduct(product);
            return serviceBasket.saveBasket(add);
        });
        //serviceBasket.saveBasket(add);
        return "getProduct";
    }






}
