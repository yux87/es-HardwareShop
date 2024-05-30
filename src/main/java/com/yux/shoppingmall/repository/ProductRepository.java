package com.yux.shoppingmall.repository;

import com.yux.shoppingmall.model.Order;
import com.yux.shoppingmall.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    Optional<Product> findByProductId(String productId);


    Optional<Product> findTopByOrderByProductIdDesc();
}