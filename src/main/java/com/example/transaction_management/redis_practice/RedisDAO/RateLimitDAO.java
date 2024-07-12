package com.example.transaction_management.redis_practice.RedisDAO;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class RateLimitDAO {

    private RedisTemplate redisTemplate;

    public static Long window = 60000L;

    public static String PREFIX_USER = "USER";

    public static int LIMIT_ACCESS = 3;

    public RateLimitDAO(RedisTemplate redisTemplate)
    {
        this.redisTemplate = redisTemplate;
    }

    public String limitAccess(Long id)
    {
        //this is a string
        Object value = redisTemplate.opsForValue().get(PREFIX_USER + id.toString());
        if(value == null)
        {
            redisTemplate.opsForValue().set(PREFIX_USER + id.toString(), 1, window, TimeUnit.MILLISECONDS);
            return "ok";
        }
        else {
            Integer count = Integer.valueOf(value.toString());
            if(count.equals(LIMIT_ACCESS))
            {
                throw new RuntimeException("ACCESS DENIED");
            }
            else {
                redisTemplate.opsForValue().increment(PREFIX_USER + id.toString());
                return "ok";
            }
        }
    }
}
