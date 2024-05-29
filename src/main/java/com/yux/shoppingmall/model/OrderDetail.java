package com.yux.shoppingmall.model;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @Column(name = "order_item_sn")
    private int orderItemSn;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "stand_price")
    private int standPrice;

    @Column(name = "item_price")
    private int itemPrice;

    // Getters and Setters

    public int getOrderItemSn() {
        return orderItemSn;
    }

    public void setOrderItemSn(int orderItemSn) {
        this.orderItemSn = orderItemSn;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
