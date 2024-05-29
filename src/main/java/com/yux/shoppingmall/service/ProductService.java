package com.yux.shoppingmall.service;


import com.yux.shoppingmall.model.Product;
import com.yux.shoppingmall.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public Optional<Product> findByProductId(String productId) {
        return productRepository.findByProductId(productId);
    }

    // 其他业务逻辑方法可以在这里添加，并根据需要使用 @Transactional 注解
}
