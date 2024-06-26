package com.yux.shoppingmall.controller;

import com.yux.shoppingmall.model.Product;
import com.yux.shoppingmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable String productId) {
        Optional<Product> product = productService.findByProductId(productId);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<Product> updateProductQuantity(@PathVariable String productId, @RequestBody Product updatedProduct) {
        Optional<Product> product = productService.findByProductId(productId);
        if (product.isPresent()) {
            Product existingProduct = product.get();
            existingProduct.setQuantity(updatedProduct.getQuantity());
            productService.save(existingProduct);
            return ResponseEntity.ok(existingProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.save(product);
        return ResponseEntity.ok(createdProduct);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable String productId, @RequestBody Product productDetails) {
        Product product = productService.findById(productId);
        if (product != null) {
            product.setProductName(productDetails.getProductName());
            product.setPrice(productDetails.getPrice());
            product.setQuantity(productDetails.getQuantity());
            Product updatedProduct = productService.save(product);
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {
        productService.deleteById(productId);
        return ResponseEntity.noContent().build();
    }
}
