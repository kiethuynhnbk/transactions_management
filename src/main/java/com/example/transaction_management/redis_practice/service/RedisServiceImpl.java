package com.example.transaction_management.redis_practice.service;

import com.example.transaction_management.redis_practice.dto.UserInfor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Qualifier("RedisStringValue")
//save redis in form of String - String
public class RedisServiceImpl implements RedisService {

    private RedisTemplate<String, Object> redisTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public RedisServiceImpl(RedisTemplate redisTemplate)
    {
        this.redisTemplate = redisTemplate;
    }

    public String convertObjectToString(Object object)
    {
        try {
            String jsonObject = objectMapper.writeValueAsString(object);
            return jsonObject;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public boolean setKeyValue(String key, Object value, Long TTL)
    {
        if(value instanceof Integer || value instanceof String)
        {
            redisTemplate.opsForValue().set(key, value, (TTL != null && TTL > 0) ? TTL : 5 * 60000 * 60, TimeUnit.MILLISECONDS);
        }
        else
        {
            String stringObject = convertObjectToString(value);
            redisTemplate.opsForValue().set(key, stringObject, (TTL != null && TTL > 0) ? TTL : 5 * 60000 * 60, TimeUnit.MILLISECONDS);
        }
        return true;


    }

    @Override
    public Object getValueByKey(String key) {
        Object value = redisTemplate.opsForValue().get(key);
        if(value == null)
        {
            throw new RuntimeException("Not found value");
        }

        if(key.startsWith("user:"))
        {
            try {
                Object obj = objectMapper.readValue((String)value, UserInfor.class);
                return obj;
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
        return value;
    }
}
