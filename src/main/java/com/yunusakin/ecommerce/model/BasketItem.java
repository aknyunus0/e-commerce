package com.yunusakin.ecommerce.model;

import javax.persistence.*;

@Entity
@Table(name="BasketItem")
public class BasketItem {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long id;

    int quantity;

    double totalBalance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", referencedColumnName = "id")
    Product product;
    @ManyToOne
    @JoinColumn(name = "basketId",referencedColumnName = "id")
    Basket basket;
    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "BasketItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", totalBalance=" + totalBalance +
                ", product=" + product +
                ", basket=" + basket +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }



}
