package com.yux.shoppingmall.repository;


import com.yux.shoppingmall.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
    Optional<Order> findByOrderId(String orderId);
    //基于当前的最大订单编号进行累加
    Optional<Order> findTopByOrderByOrderIdDesc();
    // 查詢訂單by memberId
    List<Order> findByMemberMemberId(int memberId);

}
