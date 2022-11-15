package com.yunusakin.ecommerce.model;

import javax.persistence.*;

@Entity
@Table(name="Product")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long id;
     @Column(name = "productName")
    String productName;
    @Column(name = "productDetails")
    String productDetails;
    @Column(name = "balance")
    double balance;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productDetails='" + productDetails + '\'' +
                ", balance=" + balance +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
