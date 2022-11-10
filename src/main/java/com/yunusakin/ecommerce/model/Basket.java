package com.yunusakin.ecommerce.model;
import javax.persistence.*;

@Entity
@Table(name = "Basket")
public class Basket {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long id;
    long productId;
    int sumQuantity;
    int sumBalance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getSumQuantity() {
        return sumQuantity;
    }

    public void setSumQuantity(int sumQuantity) {
        this.sumQuantity = sumQuantity;
    }

    public int getSumBalance() {
        return sumBalance;
    }

    public void setSumBalance(int sumBalance) {
        this.sumBalance = sumBalance;
    }


}
