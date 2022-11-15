package com.yunusakin.ecommerce.model;
import javax.persistence.*;

@Entity
@Table(name = "Basket")
public class Basket {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long id;
    @Column(name = "sumBalance")
    double sumBalance;

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", sumBalance=" + sumBalance +
                ", status=" + status +
                ", user=" + user +
                '}';
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Column(name = "status")
    boolean status;
    @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "userId",referencedColumnName = "id")
   User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public double getSumBalance() {
        return sumBalance;
    }

    public void setSumBalance(double sumBalance) {
        this.sumBalance = sumBalance;
    }


}
