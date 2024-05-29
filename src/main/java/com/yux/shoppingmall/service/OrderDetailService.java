package com.yux.shoppingmall.service;


import com.yux.shoppingmall.model.OrderDetail;
import com.yux.shoppingmall.repository.OrderDetailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public Optional<OrderDetail> findByOrderItemSn(Integer orderItemSn) {
        return orderDetailRepository.findByOrderItemSn(orderItemSn);
    }

    // 其他业务逻辑方法可以在这里添加
}
