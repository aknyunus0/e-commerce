package com.yunusakin.ecommerce.service;

import com.yunusakin.ecommerce.dao.BasketItemRepository;
import com.yunusakin.ecommerce.dao.BasketRepository;
import com.yunusakin.ecommerce.dao.ProductRepository;
import com.yunusakin.ecommerce.dao.UserRepository;
import com.yunusakin.ecommerce.model.Basket;
import com.yunusakin.ecommerce.model.BasketItem;
import com.yunusakin.ecommerce.model.RequestBasketItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BasketService {


    BasketItemRepository basketItemRepository;
    @Autowired
    ProductRepository ProductRepo;

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    UserRepository userRepository;



    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    long userId;

    public BasketService(BasketItemRepository basketRepo){
        this.basketItemRepository =basketRepo;

    }

    public void updateByid(long id, RequestBasketItem request){
        basketItemRepository.update(request.getQuantity(), request.getTotalBalance(), id);

    }
    public  void updateStatusBasket(boolean status,long basketId,long id){
        basketRepository.updateStatus(status,basketId ,id);
    }


    public String saveBasket(RequestBasketItem request, long productId){
        Basket basket=basketRepository.getbyUserId(userId);
        if(ObjectUtils.isEmpty(basket)){
            Basket firstBasket = new Basket();
            firstBasket.setSumBalance(request.getTotalBalance());
            firstBasket.setStatus(true);
            Optional<Object> use = userRepository.findById(userId).map(user -> {
                firstBasket.setUser(user);
                return true;
            });
         basketRepository.save(firstBasket);
         basket=basketRepository.getbyUserId(userId);
        }


        BasketItem basketItem =new BasketItem();
        List<BasketItem> basketItemsByProductIdList= basketItemRepository.getbyProductId(productId, basket.getId());
        System.out.println(basketItemsByProductIdList);

        double pTotalBalance=0.0;
        int pQuantity=0;

        int doit=0;

        if(!(basketItemsByProductIdList.isEmpty())){
            pQuantity = basketItemsByProductIdList.get(0).getQuantity();
            pTotalBalance=basketItemsByProductIdList.get(0).getTotalBalance();
            doit=basketItemRepository.saveOrUpdate(request.getQuantity()+pQuantity, request.getTotalBalance()+pTotalBalance, productId, basket.getId());
            updateSumBalanceInBasket();
        }

       if(doit==0) {
           Optional<Object> pro = ProductRepo.findById(productId).map(product -> {
               request.setProduct(product);
               return true;
           });
           Optional<Object> bas = basketRepository.findById(basket.getId()).map(basket1 -> {
               request.setBasket(basket1);
               return true;
           });
           basketItem.setBasket(request.getBasket());
           basketItem.setProduct(request.getProduct());
           basketItem.setQuantity(request.getQuantity());
           basketItem.setTotalBalance(request.getTotalBalance());


           basketItemRepository.save(basketItem);
           updateSumBalanceInBasket();


       }
        return "succes";
    }


    public void updateSumBalanceInBasket(){
        double sumBalance=0.0;
        Basket basket= basketRepository.getbyUserId(userId);
        List<BasketItem> basketItems = basketItemRepository.getbyBasketId(basket.getId());
        for (BasketItem bastke:basketItems
             ) {
            sumBalance+=bastke.getTotalBalance();

        }
        basketRepository.update(sumBalance, basket.getId());
    }
}
