package com.example.transaction_management.redis_practice.service;

import com.example.transaction_management.redis_practice.dto.Product;

import java.util.List;

public interface ProductRedisService {

    public Product save(Product product);

    public Product findById(Long id);

    public Product update(Product product);

    public Long delete(Long id);

    public List<Product> findAllProduct();
}
