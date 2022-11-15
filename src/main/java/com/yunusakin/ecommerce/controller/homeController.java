package com.yunusakin.ecommerce.controller;

import com.yunusakin.ecommerce.Security.MyUserDetails;
import com.yunusakin.ecommerce.dao.ProductRepository;
import com.yunusakin.ecommerce.model.Product;
import com.yunusakin.ecommerce.model.RequestBasketItem;
import com.yunusakin.ecommerce.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
   public ModelAndView homePage(Authentication authentication, Model model){
        authentication = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        serviceBasket.setUserId(userDetails.getUserId());
       return getAllProduct();
  }

    @RequestMapping("/getProduct")
    public ModelAndView getAllProduct() {
        ModelAndView mv = new ModelAndView("index");
       List<Product> product = ProductRepo.findAll();
        mv.addObject("product",product);
        mv.setViewName("getProduct");
        return mv;
    }

    @RequestMapping(value = "/addBasket/{productId}",method = RequestMethod.POST)
    public ModelAndView addBasket(@PathVariable(value="productId") long productId, RequestBasketItem add) {
        serviceBasket.saveBasket(add,productId);
        return getAllProduct();
    }

}
