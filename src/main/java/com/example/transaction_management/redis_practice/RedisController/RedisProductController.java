package com.example.transaction_management.redis_practice.RedisController;

import com.example.transaction_management.redis_practice.dto.Product;
import com.example.transaction_management.redis_practice.service.ProductRedisService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("redis/product")
public class RedisProductController {

    private ProductRedisService productRedisService;

    public RedisProductController(ProductRedisService productRedisService)
    {
        this.productRedisService = productRedisService;
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product)
    {
        return productRedisService.save(product);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) throws IOException {
        return productRedisService.findById(id);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return productRedisService.update(product);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        return productRedisService.delete(id);
    }

    @GetMapping
    public List<Product> findAllProduct()
    {
        return productRedisService.findAllProduct();
    }
}
