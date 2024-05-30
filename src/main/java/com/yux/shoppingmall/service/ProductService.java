package com.yux.shoppingmall.service;

import com.yux.shoppingmall.model.Order;
import com.yux.shoppingmall.model.Product;
import com.yux.shoppingmall.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public Optional<Product> findByProductId(String productId) {
        return productRepository.findByProductId(productId);
    }

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional
    public Product save(Product product) {
        product.setProductId(generateNextProductId());
        return productRepository.save(product);
    }


    @Transactional(readOnly = true)
    public Product findById(String productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Transactional
    public void deleteById(String productId) {
        productRepository.deleteById(productId);
    }

    // 其他业务逻辑方法可以在这里添加，并根据需要使用 @Transactional 注解

    private String generateNextProductId() {
        Optional<Product> maxProductOpt = productRepository.findTopByOrderByProductIdDesc();
        String maxProductId = maxProductOpt.map(Product::getProductId).orElse("P003");

        // Extract the numeric part of the current max product ID
        int numericPart = Integer.parseInt(maxProductId.substring(1));

        // Generate the new product ID
        int nextNumericPart = numericPart + 1;
        return "P" + String.format("%03d", nextNumericPart);
    }
}
