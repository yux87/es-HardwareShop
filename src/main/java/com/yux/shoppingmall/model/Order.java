package com.yux.shoppingmall.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "[order]")
public class Order {

    @Id
    @Column(name = "order_id", length = 17)
    private String orderId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "price")
    private int price;

    @Column(name = "pay_status")
    private boolean payStatus;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> orderDetails;

    // Getters and Setters

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isPayStatus() {
        return payStatus;
    }

    public void setPayStatus(boolean payStatus) {
        this.payStatus = payStatus;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
        if (orderDetails != null) {
            for (OrderDetail detail : orderDetails) {
                detail.setOrder(this);
            }
        }
    }
}
