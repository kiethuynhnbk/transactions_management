package com.example.transaction_management.redis_practice.RedisDAO;

import com.example.transaction_management.redis_practice.dto.Product;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRedisDAO {

    public static final String PRODUCT_HASH = "PRODUCT";

    private RedisTemplate template;

    public ProductRedisDAO(RedisTemplate template)
    {
        this.template = template;
    }

    public Product save(Product product)
    {
        //PRODUCT -> map<>:{1: product}
        template.opsForHash().put(PRODUCT_HASH, product.getId().toString(), product);
        return product;
    }

    public Product findById(Long id)
    {
        //PRODUCT -> map<>:{1: product}
        return (Product) template.opsForHash().get(PRODUCT_HASH, id.toString());
    }

    public Product update(Product product)
    {
        //PRODUCT -> map<>:{1: product}
        template.opsForHash().put(PRODUCT_HASH, product.getId().toString(), product);
        return product;
    }

    public Long delete(Long id)
    {
        //PRODUCT -> map<>:{1: product}
        template.opsForHash().delete(PRODUCT_HASH, id.toString());
        return id;
    }

    public List<Product> findAllProduct()
    {
        return template.opsForHash().values(PRODUCT_HASH);
    }


}
