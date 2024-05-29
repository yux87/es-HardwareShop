package com.yux.shoppingmall.dto;


import com.yux.shoppingmall.model.Order;

import java.util.List;

public class OrderData {

    private int memberId;
    private Order order;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
