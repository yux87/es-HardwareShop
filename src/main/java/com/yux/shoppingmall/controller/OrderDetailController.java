package com.yux.shoppingmall.controller;


import com.yux.shoppingmall.model.OrderDetail;
import com.yux.shoppingmall.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/order-details")
public class OrderDetailController {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @GetMapping("/{orderItemSn}")
    public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable Integer orderItemSn) {
        Optional<OrderDetail> orderDetail = orderDetailRepository.findByOrderItemSn(orderItemSn);
        return orderDetail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

