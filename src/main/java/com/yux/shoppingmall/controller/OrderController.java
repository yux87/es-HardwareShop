package com.yux.shoppingmall.controller;

import com.yux.shoppingmall.model.Order;
import com.yux.shoppingmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/by-member/{memberId}")
    public ResponseEntity<List<Order>> getOrdersByMemberId(@PathVariable int memberId) {
        List<Order> orders = orderService.findByMemberId(memberId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable String orderId) {
        Optional<Order> order = orderService.findByOrderId(orderId);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.save(order);
        return ResponseEntity.ok(createdOrder);
    }
}


