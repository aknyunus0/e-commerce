package com.yunusakin.ecommerce.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Basket")
public class Basket {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long id;
@Basic
@Column(name = "numberOfProduct")
    int numberOfProduct;
    @Basic
    @Column(name = "totalBalance")
    double totalBalance;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "productId", referencedColumnName = "id")
    Product product;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumberOfProduct() {
        return numberOfProduct;
    }

    public void setNumberOfProduct(int numberOfProduct) {
        this.numberOfProduct = numberOfProduct;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }



}
