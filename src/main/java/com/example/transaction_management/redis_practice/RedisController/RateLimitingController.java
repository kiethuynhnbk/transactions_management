package com.example.transaction_management.redis_practice.RedisController;

import com.example.transaction_management.redis_practice.dto.UserInfor;
import com.example.transaction_management.redis_practice.service.RateLimitingService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rateLimiting")
public class RateLimitingController {

    private RateLimitingService rateLimitingService;

    private RedisTemplate redisTemplate;

    public RateLimitingController(RateLimitingService rateLimitingService, RedisTemplate redisTemplate)
    {
        this.rateLimitingService = rateLimitingService;
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/{id}")
    public String accessResouce(@PathVariable Long id)
    {
        return rateLimitingService.rateLimitService(id);
    }

}
