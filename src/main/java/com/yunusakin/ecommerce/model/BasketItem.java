package com.yunusakin.ecommerce.model;

import javax.persistence.*;

@Entity
@Table(name="BasketItem")
public class BasketItem {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long id;

    @Override
    public String toString() {
        return "BasketItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", totalBalance=" + totalBalance +
                ", product=" + product +
                '}';
    }

    @Basic
@Column(name = "quantity")
    int quantity;
    @Basic
    @Column(name = "totalBalance")
    double totalBalance;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId", referencedColumnName = "id")
    Product product;


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
