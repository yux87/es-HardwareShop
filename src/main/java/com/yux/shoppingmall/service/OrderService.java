package com.yux.shoppingmall.service;

import com.yux.shoppingmall.model.Member;
import com.yux.shoppingmall.model.Order;
import com.yux.shoppingmall.repository.MemberRepository;
import com.yux.shoppingmall.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MemberRepository memberRepository;


    @Transactional(readOnly = true)
    public List<Order> findByMemberId(int memberId) {
        return orderRepository.findByMemberMemberId(memberId);
    }


    @Transactional(readOnly = true)
    public Optional<Order> findByOrderId(String orderId) {
        return orderRepository.findByOrderId(orderId);
    }

//    @Transactional
//    public Order save(Order order) {
//        // 生成唯一的订单ID
//        order.setOrderId(UUID.randomUUID().toString());
//        return orderRepository.save(order);
//    }

    @Transactional
    public Order save(Order order, int memberId) {
        Optional<Member> memberOpt = memberRepository.findById(memberId);
        if (memberOpt.isPresent()) {
            order.setMember(memberOpt.get());
            order.setOrderId(generateNextOrderId());
//            System.out.println(generateNextOrderId());
//            order.setOrderId("Ms20250805258201");
            return orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Invalid member ID");
        }
    }

//    @Transactional
//    public Order save(Order order) {
//        // 生成唯一的订单ID
//        order.setOrderId(generateNextOrderId());
//        return orderRepository.save(order);
//    }

    private String generateNextOrderId() {
        // 获取当前最大订单ID
        Optional<Order> maxOrderOpt = orderRepository.findTopByOrderByOrderIdDesc();
        System.out.println(maxOrderOpt.map(Order::getOrderId));
        String maxOrderId = maxOrderOpt.map(Order::getOrderId).orElse("Ms20250805258200");

        // 提取当前订单ID中的数字部分
        String datePart = maxOrderId.substring(2, 10); // 20250805
        String numericPart = maxOrderId.substring(10); // 258200
        System.out.println("datePart"+datePart);
        System.out.println("numericPart"+numericPart);

        // 生成新的订单ID
//        long nextNumericPart = Long.parseLong(numericPart) + 1;
        Integer nextNumericPart = Integer.parseInt(numericPart) + 1;
//        return "Ms" + datePart + String.format("%08d", nextNumericPart);
        return "Ms" + datePart + String.format("%06d", nextNumericPart);
    }

    // 其他业务逻辑方法可以在这里添加，并根据需要使用 @Transactional 注解
}
