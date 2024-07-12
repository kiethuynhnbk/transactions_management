package com.example.transaction_management.redis_practice.service;

import com.example.transaction_management.redis_practice.RedisDAO.ProductRedisDAO;
import com.example.transaction_management.redis_practice.dto.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRedisServiceImpl implements ProductRedisService {

    private ProductRedisDAO productRedisDAO;

    public ProductRedisServiceImpl(ProductRedisDAO productRedisDAO)
    {
        this.productRedisDAO = productRedisDAO;
    }

    @Override
    public Product save(Product product) {
        return productRedisDAO.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRedisDAO.findById(id);
    }

    @Override
    public Product update(Product product) {
        return productRedisDAO.update(product);
    }

    @Override
    public Long delete(Long id) {
        return productRedisDAO.delete(id);
    }

    @Override
    public List<Product> findAllProduct() {
        //check some filter
//        return productRedisDAO.findAllProduct().stream().filter(x -> x.getPrice() < 300)
//                .toList();
        return productRedisDAO.findAllProduct();
    }
}
