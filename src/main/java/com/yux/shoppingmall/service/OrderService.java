package com.yux.shoppingmall.service;

import com.yux.shoppingmall.model.Order;
import com.yux.shoppingmall.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public Optional<Order> findByOrderId(String orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    // 其他业务逻辑方法可以在这里添加，并根据需要使用 @Transactional 注解
}
