package com.example.transaction_management.redis_practice.service;

import com.example.transaction_management.redis_practice.RedisDAO.RateLimitDAO;
import org.springframework.stereotype.Service;

@Service
public class RateLimitServiceImpl implements RateLimitingService {

    private RateLimitDAO rateLimitDAO;

    public RateLimitServiceImpl(RateLimitDAO rateLimitDAO)
    {
        this.rateLimitDAO = rateLimitDAO;
    }


    @Override
    public String rateLimitService(Long id) {
        rateLimitDAO.limitAccess(id);
        return "ACCESS ALLOWED";
    }
}
