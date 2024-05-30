package com.yux.shoppingmall.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_sn")
    private Integer orderItemSn;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "stand_price")
    private int standPrice;

    @Column(name = "item_price")
    private int itemPrice;

    // Getters and Setters

    public Integer getOrderItemSn() {
        return orderItemSn;
    }

    public void setOrderItemSn(Integer orderItemSn) {
        this.orderItemSn = orderItemSn;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStandPrice() {
        return standPrice;
    }

    public void setStandPrice(int standPrice) {
        this.standPrice = standPrice;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }
}
